package com.traffic.simulator.app.pattern.state;

import com.traffic.simulator.app.entity.traffic.TrafficLight;

public class GreenState implements TrafficLightState {
    @Override
    public void handle(TrafficLight light) {
        System.out.println("Green light -> Cars are allowed");

        light.sleepSeconds(getDuration());

        light.setState(new YellowState());
    }

    @Override
    public String getName() {
        return "GREEN";
    }

    @Override
    public int getDuration() {
        return 5;
    }
}