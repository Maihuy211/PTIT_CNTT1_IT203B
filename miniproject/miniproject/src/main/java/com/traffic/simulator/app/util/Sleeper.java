package com.traffic.simulator.app.util;

@FunctionalInterface
public interface Sleeper {
    void sleepMillis(long millis) throws InterruptedException;
}

