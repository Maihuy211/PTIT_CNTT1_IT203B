package com.traffic.simulator.app.entity.vehicle;

public class PriorityVehicle extends Vehicle {

    public PriorityVehicle(String id, VehicleType type, int speed) {
        super(id, type, speed, 10);
    }

    @Override
    public boolean isPriorityVehicle() {
        return true;
    }

    @Override
    public void crossIntersection() {
        setStatus(VehicleStatus.CROSSING);
        System.out.println(getDisplayName() + " Crossing the intersection with the right of way.");

        setStatus(VehicleStatus.PASSED);
        System.out.println(getDisplayName() + " We passed the intersection safely.");
    }

    @Override
    public String getDescription() {
        return "Priority vehicle - " + getDisplayName() + ", Speed: " + getSpeed();
    }
}

