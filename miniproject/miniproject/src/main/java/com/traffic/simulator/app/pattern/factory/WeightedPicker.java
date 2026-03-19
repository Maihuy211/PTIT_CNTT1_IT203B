package com.traffic.simulator.app.pattern.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class WeightedPicker<T> {

    private final Random random;

    private final List<T> items = new ArrayList<>();
    private final List<Integer> prefixSums = new ArrayList<>();
    private int total = 0;

    public WeightedPicker(Random random) {
        this.random = Objects.requireNonNull(random, "random");
    }

    public void clear() {
        items.clear();
        prefixSums.clear();
        total = 0;
    }

    public void add(T item, int weight) {
        if (weight <= 0) return;
        total += weight;
        items.add(item);
        prefixSums.add(total);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int totalWeight() {
        return total;
    }

    public T pick() {
        if (items.isEmpty() || total <= 0) {
            throw new IllegalStateException("WeightedPicker is empty or total weight <= 0");
        }

        int r = random.nextInt(total) + 1;
        for (int i = 0; i < prefixSums.size(); i++) {
            if (r <= prefixSums.get(i)) return items.get(i);
        }
        return items.get(items.size() - 1);
    }
}