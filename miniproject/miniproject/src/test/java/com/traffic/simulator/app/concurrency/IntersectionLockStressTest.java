package com.traffic.simulator.app.concurrency;

import com.traffic.simulator.app.entity.vehicle.Car;
import com.traffic.simulator.app.entity.vehicle.Vehicle;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IntersectionLockStressTest {

    @Test
    void shouldNotAllowMoreThanOneVehicleInsideIntersection() throws Exception {
        IntersectionLock lock = new IntersectionLock();

        int vehicles = 100;
        ExecutorService pool = Executors.newFixedThreadPool(16);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(vehicles);

        AtomicInteger inside = new AtomicInteger(0);
        AtomicInteger maxInside = new AtomicInteger(0);

        List<Throwable> errors = new ArrayList<>();

        for (int i = 0; i < vehicles; i++) {
            Vehicle v = new Car("C" + i, 60);
            pool.submit(() -> {
                try {
                    start.await();
                    lock.enterIntersection(v);

                    int now = inside.incrementAndGet();
                    maxInside.accumulateAndGet(now, Math::max);

                    // mô phỏng thời gian đi qua giao lộ
                    Thread.sleep(2);

                    inside.decrementAndGet();
                    lock.leaveIntersection(v);
                } catch (Throwable t) {
                    synchronized (errors) {
                        errors.add(t);
                    }
                } finally {
                    done.countDown();
                }
            });
        }

        start.countDown();
        assertTrue(done.await(10, TimeUnit.SECONDS), "Các tác vụ không hoàn thành kịp thời gian");

        pool.shutdownNow();

        if (!errors.isEmpty()) {
            Throwable first = errors.get(0);
            throw new AssertionError("Có lỗi trong quá trình chạy đa luồng: " + first, first);
        }

        assertEquals(0, inside.get());
        assertEquals(1, maxInside.get(), "Đã có hơn 1 xe ở trong giao lộ cùng lúc");
    }
}

