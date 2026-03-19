package com.traffic.simulator.app.pattern.state;

import com.traffic.simulator.app.entity.traffic.TrafficLight;
import com.traffic.simulator.app.util.Sleeper;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrafficLightStateTest {

    @Test
    void shouldCycleGreenYellowRedWithoutRealSleep() {
        AtomicLong sleptMillis = new AtomicLong();
        Sleeper fakeSleeper = millis -> sleptMillis.addAndGet(millis);

        TrafficLight light = new TrafficLight(fakeSleeper);

        // trạng thái ban đầu: GREEN (constructor)
        assertEquals("GREEN", light.getCurrentStateName());

        // GREEN -> YELLOW
        light.getCurrentState().handle(light);
        assertEquals("YELLOW", light.getCurrentStateName());

        // YELLOW -> RED
        light.getCurrentState().handle(light);
        assertEquals("RED", light.getCurrentStateName());

        // RED -> GREEN
        light.getCurrentState().handle(light);
        assertEquals("GREEN", light.getCurrentStateName());

        // kiểm tra tổng thời gian sleep: 5s + 2s + 5s
        assertEquals((5 + 2 + 5) * 1000, sleptMillis.get());
    }
}

