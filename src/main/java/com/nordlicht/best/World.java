package com.nordlicht.best;

import com.nordlicht.best.animal.AAnimal;

import java.util.ArrayList;
import java.util.List;

public class World {
    private static final World INSTANCE = new World();
    private final List<AAnimal> animals = new ArrayList<>();

    private World() {
    }

    public static World getInstance() {
        return INSTANCE;
    }

    public List<AAnimal> getAnimals() {
        return animals;
    }

    public void addAnimal(AAnimal animal) {
        animals.add(animal);
    }
}
