package com.traffic.simulator.app.entity.vehicle;

import com.traffic.simulator.app.util.LoggerUtil;

public class Motorcycle extends StandardVehicle {

    public Motorcycle(String id, int speed) {
        super(id, VehicleType.MOTORCYCLE, speed);
    }

    @Override
    public void move() {
        setStatus(VehicleStatus.MOVING);
        LoggerUtil.log(getDisplayName() + " is moving quickly towards the intersection");
    }

    @Override
    public void waitForGreen() {
        setStatus(VehicleStatus.WAITING);
        LoggerUtil.log(getDisplayName() + " is waiting at the red light");
    }

    @Override
    public String getDescription() {
        return "Motorcycle - " + getDisplayName() + ", Speed: " + getSpeed();
    }
}