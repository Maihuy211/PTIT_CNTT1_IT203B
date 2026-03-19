package com.traffic.simulator.app.engine;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;


public class VehicleSpawnConfig {

    private final Map<String, Integer> weights = new LinkedHashMap<>();

    public VehicleSpawnConfig setWeight(String vehicleType, int weight) {
        Objects.requireNonNull(vehicleType, "vehicleType");
        if (weight < 0) throw new IllegalArgumentException("weight must be >= 0");
        weights.put(vehicleType, weight);
        return this;
    }

    public int getWeight(String vehicleType) {
        return weights.getOrDefault(vehicleType, 0);
    }

    public Map<String, Integer> getWeightsView() {
        return Collections.unmodifiableMap(weights);
    }

    public int totalWeight() {
        int sum = 0;
        for (int w : weights.values()) sum += Math.max(0, w);
        return sum;
    }
}