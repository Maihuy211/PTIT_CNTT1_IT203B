package com.traffic.simulator.app.engine;

import com.traffic.simulator.app.concurrency.IntersectionLock;
import com.traffic.simulator.app.concurrency.ThreadManager;
import com.traffic.simulator.app.concurrency.VehicleTask;
import com.traffic.simulator.app.entity.traffic.TrafficLight;
import com.traffic.simulator.app.entity.vehicle.*;

import java.util.Random;

public class SimulationEngine {

    private final Random random = new Random();
    private final IntersectionLock intersectionLock = new IntersectionLock();
    private final TrafficLight trafficLight = new TrafficLight();
    private final ThreadManager threadManager = new ThreadManager(8);
    private Thread trafficLightThread;

    public void start() {
        startTrafficLightIfNeeded();

        // tạo nhiều xe (demo)
        for (int i = 1; i <= 10; i++) {
            Vehicle vehicle = createRandomVehicle(i);
            threadManager.submitTask(() -> runVehicle(vehicle));
        }
    }

    public void stop() {
        trafficLight.stop();
        threadManager.shutdown();
    }

    private void startTrafficLightIfNeeded() {
        if (trafficLightThread != null) return;
        trafficLightThread = new Thread(trafficLight, "traffic-light");
        trafficLightThread.setDaemon(true);
        trafficLightThread.start();
    }

    private void runVehicle(Vehicle vehicle) {
        try {
            // thời gian xe đến ngẫu nhiên
            Thread.sleep(random.nextInt(2000));

            new VehicleTask(vehicle, intersectionLock, trafficLight).run();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // random loại xe
    private Vehicle createRandomVehicle(int id) {
        int type = random.nextInt(4);

        String vehicleId = generateId(type, id);
        int speed = random.nextInt(40) + 40; // tốc độ 40-80

        switch (type) {
            case 0:
                return new Car(vehicleId, speed);
            case 1:
                return new Motorcycle(vehicleId, speed);
            case 2:
                return new Truck(vehicleId, speed);
            default:
                return new Ambulance(vehicleId, speed);
        }
    }

    // tạo id
    private String generateId(int type, int id) {
        switch (type) {
            case 0: return "C" + id;
            case 1: return "M" + id;
            case 2: return "T" + id;
            default: return "A" + id;
        }
    }
}