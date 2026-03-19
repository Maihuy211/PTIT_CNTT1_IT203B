package com.traffic.simulator.app.entity.traffic;

import com.traffic.simulator.app.pattern.state.GreenState;
import com.traffic.simulator.app.pattern.state.TrafficLightState;
import com.traffic.simulator.app.util.Sleeper;
import com.traffic.simulator.app.util.ThreadSleeper;

import java.util.Objects;

public class TrafficLight implements Runnable {

    private TrafficLightState currentState;
    private boolean running = true;
    private final Sleeper sleeper;

    public TrafficLight() {
        this(new ThreadSleeper());
    }

    public TrafficLight(Sleeper sleeper) {
        this.sleeper = Objects.requireNonNull(sleeper, "sleeper");
        this.currentState = new GreenState();
    }

    public synchronized void setState(TrafficLightState state) {
        this.currentState = state;
        System.out.println("Switch status: " + state.getName());
    }

    public synchronized String getCurrentStateName() {
        return currentState.getName();
    }

    public synchronized TrafficLightState getCurrentState() {
        return currentState;
    }

    public void stop() {
        running = false;
    }

    public void sleepSeconds(int seconds) {
        try {
            sleeper.sleepMillis(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void run() {
        System.out.println("=== The traffic lights have turned on. ===");

        while (running) {
            currentState.handle(this);
        }

        System.out.println("=== The traffic light has stopped. ===");
    }

    public boolean isGreen() {
        return currentState instanceof GreenState;
    }
}