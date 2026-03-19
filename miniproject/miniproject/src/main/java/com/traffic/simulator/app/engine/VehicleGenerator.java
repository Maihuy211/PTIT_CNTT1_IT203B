package com.traffic.simulator.app.engine;

import com.traffic.simulator.app.entity.vehicle.Vehicle;
import com.traffic.simulator.app.pattern.factory.VehicleFactory;
import com.traffic.simulator.app.pattern.factory.WeightedPicker;

import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class VehicleGenerator {

    private final VehicleFactory factory;
    private final Random random;
    private final WeightedPicker<String> typePicker;

    private VehicleSpawnConfig config;

    public VehicleGenerator(VehicleFactory factory) {
        this(factory, new Random());
    }

    public VehicleGenerator(VehicleFactory factory, Random random) {
        this.factory = Objects.requireNonNull(factory, "factory");
        this.random = Objects.requireNonNull(random, "random");
        this.typePicker = new WeightedPicker<>(this.random);
    }

    public void configure(VehicleSpawnConfig config) {
        Objects.requireNonNull(config, "config");

        if (config.totalWeight() <= 0) {
            throw new IllegalArgumentException("Total weight must be > 0");
        }

        // Validate all types in config must be registered in factory (if weight > 0)
        for (Map.Entry<String, Integer> e : config.getWeightsView().entrySet()) {
            String type = e.getKey();
            int weight = e.getValue();
            if (weight > 0 && !factory.isRegistered(type)) {
                throw new IllegalArgumentException("Vehicle type not registered in factory: " + type);
            }
        }

        this.config = config;
        rebuildPicker();
    }

    private void rebuildPicker() {
        typePicker.clear();
        for (Map.Entry<String, Integer> e : config.getWeightsView().entrySet()) {
            typePicker.add(e.getKey(), e.getValue());
        }

        if (typePicker.isEmpty()) {
            throw new IllegalStateException("No vehicle types with weight > 0");
        }
    }

    public Vehicle nextVehicle() {
        if (config == null) {
            throw new IllegalStateException("VehicleGenerator is not configured. Call configure() first.");
        }
        String type = typePicker.pick();
        return factory.create(type);
    }
}