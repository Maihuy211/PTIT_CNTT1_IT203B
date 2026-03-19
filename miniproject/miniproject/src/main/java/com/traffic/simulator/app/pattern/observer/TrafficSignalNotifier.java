package com.traffic.simulator.app.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class TrafficSignalNotifier implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String state;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(state);
        }
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("Traffic Light: " + state);
        notifyObservers();
    }
}
