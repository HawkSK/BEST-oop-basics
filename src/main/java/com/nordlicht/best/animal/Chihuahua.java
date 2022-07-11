package com.nordlicht.best.animal;

public class Chihuahua extends Dog {

    public Chihuahua(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("Grrrrr!");
    }
}
