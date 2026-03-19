package com.traffic.simulator.app.entity.vehicle;

import com.traffic.simulator.app.util.LoggerUtil;

public class Truck extends StandardVehicle {

    public Truck(String id, int speed) {
        super(id, VehicleType.TRUCK, speed);
    }

    @Override
    public void move() {
        setStatus(VehicleStatus.MOVING);
        LoggerUtil.log(getDisplayName() + " is moving slowly towards the intersection");
    }

    @Override
    public void waitForGreen() {
        setStatus(VehicleStatus.WAITING);
        LoggerUtil.log(getDisplayName() + " is waiting at the red light");
    }

    @Override
    public String getDescription() {
        return "Truck - " + getDisplayName() + ", Speed: " + getSpeed();
    }
}