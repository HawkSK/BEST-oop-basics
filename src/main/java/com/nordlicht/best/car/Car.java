package com.nordlicht.best.car;

import com.nordlicht.best.Noisy;

public class Car implements Noisy {
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void makeNoise() {
        System.out.println("Vroom vroom.");
    }
}
