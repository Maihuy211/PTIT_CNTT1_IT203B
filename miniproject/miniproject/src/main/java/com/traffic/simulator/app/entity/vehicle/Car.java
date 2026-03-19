package com.traffic.simulator.app.entity.vehicle;

import com.traffic.simulator.app.util.LoggerUtil;

public class Car extends StandardVehicle {

    public Car(String id, int speed) {
        super(id, VehicleType.CAR, speed);
    }

    @Override
    public void move() {
        setStatus(VehicleStatus.MOVING);
        LoggerUtil.log(getDisplayName() + " is moving towards the intersection");
    }

    @Override
    public void waitForGreen() {
        setStatus(VehicleStatus.WAITING);
        LoggerUtil.log(getDisplayName() + " is waiting at the red light");
    }

    @Override
    public String getDescription() {
        return "Car - " + getDisplayName() + ", Speed: " + getSpeed();
    }
}