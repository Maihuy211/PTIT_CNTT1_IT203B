package com.traffic.simulator.app.util;

public class ThreadSleeper implements Sleeper {
    @Override
    public void sleepMillis(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }
}

