package com.nordlicht.best.animal;

public class Dog extends AAnimal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeNoise() {
        System.out.println("Woof woof!");
    }
}
