package com.traffic.simulator.app.pattern.factory;

import com.traffic.simulator.app.entity.vehicle.Vehicle;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;


public class VehicleFactory {

    private final Map<String, Supplier<? extends Vehicle>> registry = new LinkedHashMap<>();

    public VehicleFactory register(String vehicleType, Supplier<? extends Vehicle> creator) {
        Objects.requireNonNull(vehicleType, "vehicleType");
        Objects.requireNonNull(creator, "creator");
        registry.put(vehicleType, creator);
        return this;
    }

    public Vehicle create(String vehicleType) {
        Supplier<? extends Vehicle> supplier = registry.get(vehicleType);
        if (supplier == null) {
            throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
        }
        return supplier.get();
    }

    public boolean isRegistered(String vehicleType) {
        return registry.containsKey(vehicleType);
    }

    public Map<String, Supplier<? extends Vehicle>> getRegistryView() {
        return Collections.unmodifiableMap(registry);
    }
}