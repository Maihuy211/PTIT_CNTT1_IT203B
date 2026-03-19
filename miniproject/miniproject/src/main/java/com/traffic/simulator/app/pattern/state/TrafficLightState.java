package com.traffic.simulator.app.pattern.state;

import com.traffic.simulator.app.entity.traffic.TrafficLight;


public interface TrafficLightState {
    void handle(TrafficLight light);

    String getName();
    int getDuration();
}