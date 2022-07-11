package com.nordlicht.best.beverage;

public abstract class Liquid {
    int temperature = 20;

    public int getTemperature() {
        return temperature;
    }

    public void heat(int targetTemperature) {
        temperature = targetTemperature;
    }
}
