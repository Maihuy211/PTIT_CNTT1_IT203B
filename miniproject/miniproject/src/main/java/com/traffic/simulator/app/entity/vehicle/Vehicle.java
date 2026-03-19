package com.traffic.simulator.app.entity.vehicle;

public abstract class Vehicle implements Runnable {

    private String id;
    private VehicleType type;
    private int speed;
    private int priority;
    private VehicleStatus status;

    public Vehicle(String id, VehicleType type, int speed, int priority) {
        this.id = id;
        this.type = type;
        this.speed = speed;
        this.priority = priority;
        this.status = VehicleStatus.CREATED;
    }

    // ===== GETTER =====
    public String getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPriority() {
        return priority;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    // ===== SETTER =====
    public void setSpeed(int speed) {
        if (speed > 0) {
            this.speed = speed;
        }
    }

    public void setPriority(int priority) {
        if (priority >= 0) {
            this.priority = priority;
        }
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    // ===== LOGIC =====
    public boolean isPriorityVehicle() {
        return false;
    }

    public void move() {
        setStatus(VehicleStatus.MOVING);
        System.out.println(getDisplayName() + " is moving towards the intersection.");
    }

    public void stop() {
        setStatus(VehicleStatus.STOPPED);
        System.out.println(getDisplayName() + " has stopped.");
    }

    public void waitForGreen() {
        setStatus(VehicleStatus.WAITING);
        System.out.println(getDisplayName() + " Waiting for the green light.");
    }

    public void crossIntersection() {
        setStatus(VehicleStatus.CROSSING);
        System.out.println(getDisplayName() + " is crossing the intersection.");

        setStatus(VehicleStatus.PASSED);
        System.out.println(getDisplayName() + " has passed the intersection.");
    }

    public String getDisplayName() {
        return type + " #" + id;
    }

    public abstract String getDescription();

    @Override
    public void run() {
        move();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", speed=" + speed +
                ", priority=" + priority +
                ", status=" + status +
                '}';
    }
}