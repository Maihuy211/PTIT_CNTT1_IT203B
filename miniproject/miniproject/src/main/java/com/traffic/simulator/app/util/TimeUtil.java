package com.traffic.simulator.app.util;

public class TimeUtil {
    private static final long startTime = System.currentTimeMillis();

    public static long getCurrentTimeSeconds() {
        return (System.currentTimeMillis() - startTime) / 1000;
    }
}