package com.nordlicht.best;

import com.nordlicht.best.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class World {
    private static final World INSTANCE = new World();
    private final List<Animal> animals = new ArrayList<>();

    private World() {
    }

    public static World getInstance() {
        return INSTANCE;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
}
