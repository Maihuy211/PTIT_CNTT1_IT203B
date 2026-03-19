package com.traffic.simulator.app.pattern.state;

import com.traffic.simulator.app.entity.traffic.TrafficLight;

public class RedState implements TrafficLightState {
    @Override
    public void handle(TrafficLight light) {
        System.out.println("Red light -> Cars must stop");
        light.sleepSeconds(getDuration());
        light.setState(new GreenState());
    }
    @Override
    public String getName() {
        return "RED";
    }
    @Override
    public int getDuration() {
        return 5;
    }
}
