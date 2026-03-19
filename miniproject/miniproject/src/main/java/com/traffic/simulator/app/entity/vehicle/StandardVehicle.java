package com.traffic.simulator.app.entity.vehicle;

public class StandardVehicle extends Vehicle {

    public StandardVehicle(String id, VehicleType type, int speed) {
        super(id, type, speed, 1);
    }

    @Override
    public String getDescription() {
        return "Standard car - " + getDisplayName() + ", Speed: " + getSpeed();
    }
}