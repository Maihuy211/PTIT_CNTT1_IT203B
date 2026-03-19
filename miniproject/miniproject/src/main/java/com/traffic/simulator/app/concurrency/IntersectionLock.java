package com.traffic.simulator.app.concurrency;

import com.traffic.simulator.app.entity.vehicle.Vehicle;
import com.traffic.simulator.app.util.LoggerUtil;

import java.util.concurrent.locks.ReentrantLock;

public class IntersectionLock {

    private final ReentrantLock lock = new ReentrantLock(true);

    public void enterIntersection(Vehicle vehicle) {
        lock.lock();
        LoggerUtil.log("Vehicle " + vehicle.getId() + " has entered the intersection");
    }

    public void leaveIntersection(Vehicle vehicle) {
        LoggerUtil.log("Vehicle " + vehicle.getId() + " has exited the intersection");
        lock.unlock();
    }
}