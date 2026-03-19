package com.traffic.simulator.app.entity.traffic;

import com.traffic.simulator.app.entity.vehicle.Vehicle;

import java.util.concurrent.Semaphore;

public class Intersection {

    private final Semaphore semaphore;

    public Intersection(int maxVehicles) {
        this.semaphore = new Semaphore(maxVehicles);
    }
    public void requestEntry(Vehicle vehicle) {
        try {
            System.out.println("The " + vehicle.getType() + " #" + vehicle.getId() + " waiting...");

            semaphore.acquire();

            System.out.println("The " + vehicle.getType() + " #" + vehicle.getId() + " entered the intersection");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public void release(Vehicle vehicle) {
        System.out.println("⬅The " + vehicle.getType() + " #" + vehicle.getId() + " have exited the intersection.");
        semaphore.release();
    }
}
