package com.traffic.simulator.app.monitor;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TrafficMonitor {

    private AtomicInteger totalPassed = new AtomicInteger(0);

    private AtomicInteger trafficJamCount = new AtomicInteger(0);

    private Map<String, AtomicInteger> vehicleStats = new ConcurrentHashMap<>();


    public void vehiclePassed(String type) {
        totalPassed.incrementAndGet();

        vehicleStats.putIfAbsent(type, new AtomicInteger(0));
        vehicleStats.get(type).incrementAndGet();

        log("The " + type + " Passed the intersection");
    }

    public void trafficJamDetected() {
        trafficJamCount.incrementAndGet();
        log(" Traffic jam!");
    }

    public void log(String message) {
        System.out.println("[TIME " + System.currentTimeMillis() % 100000 + "] " + message);
    }


    public void printReport() {
        System.out.println("\n===== REPORT =====");
        System.out.println("The total car passed: " + totalPassed.get());
        System.out.println("Number of traffic jams: " + trafficJamCount.get());

        System.out.println("\nDetails:");
        vehicleStats.forEach((k, v) -> {
            System.out.println(k + ": " + v.get());
        });
    }
}