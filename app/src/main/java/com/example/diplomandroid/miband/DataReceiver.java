package com.example.diplomandroid.miband;

import java.util.Random;

public class DataReceiver {
    private final Random random = new Random();
    private boolean connectStatus;
    private int steps;
    private int calories;
    private int distance;

    public DataReceiver() {
        generateSteps();
        generateDistance();
        generateCalories();
    }

    private void generateConnect() {
        connectStatus = random.nextBoolean();
    }

    private void generateSteps() {
        int min = 1000;
        int max = 10000;
        max -= min;
        steps = (int) ((Math.random() * ++max) + min);
    }

    private void generateDistance() {
        distance = (int) (steps / 1.5);
    }

    private void generateCalories() {
        calories = (int) (steps * 0.33);
    }

    public boolean isConnectStatus() {
        return connectStatus;
    }

    public void setConnectStatus(boolean connectStatus) {
        this.connectStatus = connectStatus;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
