package com.traffic.simulator.app.entity.vehicle;

import com.traffic.simulator.app.util.LoggerUtil;

public class Ambulance extends PriorityVehicle {

    public Ambulance(String id, int speed) {
        super(id, VehicleType.AMBULANCE, speed);
    }

    @Override
    public void move() {
        setStatus(VehicleStatus.MOVING);
        LoggerUtil.log(getDisplayName() + " is moving urgently towards the intersection");
    }

    @Override
    public void waitForGreen() {
        setStatus(VehicleStatus.WAITING);
        LoggerUtil.log(getDisplayName() + " is waiting, may be given priority to run the red light");
    }

    @Override
    public String getDescription() {
        return "Ambulance - " + getDisplayName() +
                ", Speed: " + getSpeed() +
                ", high priority";
    }
}