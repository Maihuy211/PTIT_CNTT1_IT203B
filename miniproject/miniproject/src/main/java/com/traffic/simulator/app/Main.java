package com.traffic.simulator.app;

import com.traffic.simulator.app.engine.SimulationEngine;

public class Main {
    public static void main(String[] args) {

        System.out.println("Start Simulation");

        SimulationEngine engine = new SimulationEngine();
        engine.start();

        Runtime.getRuntime().addShutdownHook(new Thread(engine::stop));

        int durationSeconds = 10;
        if (args != null && args.length > 0) {
            try {
                durationSeconds = Integer.parseInt(args[0]);
            } catch (NumberFormatException ignored) {
            }
        }

        try {
            Thread.sleep(durationSeconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        engine.stop();

        System.out.println("End Simulation");
    }
}
