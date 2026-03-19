package com.traffic.simulator.app.pattern.state;


import com.traffic.simulator.app.entity.traffic.TrafficLight;

public class YellowState implements TrafficLightState {

    @Override
    public void handle(TrafficLight light) {
        System.out.println("Yellow light -> Prepare to stop");
        light.sleepSeconds(getDuration());
        light.setState(new RedState());
    }
    @Override
    public String getName() {
        return "YELLOW";
    }
    @Override
    public int getDuration() {
        return 2;
    }
}