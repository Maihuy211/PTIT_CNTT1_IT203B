package com.traffic.simulator.app.util;

public class LoggerUtil {
    public static void log(String message) {
        long time = TimeUtil.getCurrentTimeSeconds();
        System.out.println("[Time: " + time + "s] " + message);
    }
}
