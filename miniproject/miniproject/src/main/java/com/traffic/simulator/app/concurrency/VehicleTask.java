package com.traffic.simulator.app.concurrency;

import com.traffic.simulator.app.entity.traffic.TrafficLight;
import com.traffic.simulator.app.entity.vehicle.Vehicle;
import com.traffic.simulator.app.util.LoggerUtil;

public class VehicleTask implements Runnable {

    private final Vehicle vehicle;
    private final IntersectionLock intersectionLock;
    private final TrafficLight trafficLight;

    public VehicleTask(Vehicle vehicle,
                       IntersectionLock intersectionLock,
                       TrafficLight trafficLight) {
        this.vehicle = vehicle;
        this.intersectionLock = intersectionLock;
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        try {

            approachIntersection();

            intersectionLock.enterIntersection(vehicle);

            vehicle.move();

            Thread.sleep(1000);

            intersectionLock.leaveIntersection(vehicle);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void approachIntersection() throws InterruptedException {

        boolean isWaitingLogged = false;

        while (!trafficLight.isGreen()) {
            if (!isWaitingLogged) {
                LoggerUtil.log("Vehicle " + vehicle.getId() + " is waiting at the red light");
                isWaitingLogged = true;
            }
            Thread.sleep(500);
        }

        LoggerUtil.log("Vehicle " + vehicle.getId() + " is approaching the intersection");
    }
}