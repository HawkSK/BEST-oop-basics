package com.nordlicht.best.animal;

import java.util.ArrayList;
import java.util.List;

public class FoodBowl implements Food {
    private final int CAPACITY = 100;

    private final List<FilledEvent> observers = new ArrayList<>();
    private int fullness;

    public FoodBowl(int fullness) {
        this.fullness  = fullness;
    }

    public FoodBowl() {
        this(0);
    }

    public int getFullness() {
        return fullness;
    }

    @Override
    public int getAvailableFood() {
        return getFullness();
    }

    @Override
    public void eat(int amount) {
        if (amount > fullness) {
            throw new IllegalArgumentException();
        }
        fullness -= amount;
        System.out.println(fullness + " food is left in the FoodBowl.");
    }

    public void fill(int amount) {
        if (fullness + amount > CAPACITY) {
            throw new IllegalArgumentException();
        }
        fullness += amount;
        publishUpdate();
    }

    public void subscribe(FilledEvent update) {
        observers.add(update);
    }

    private void publishUpdate() {
        for (FilledEvent observer : observers) {
            observer.onFoodBowlUpdated(getAvailableFood());
        }
    }

    @FunctionalInterface
    public interface FilledEvent {
        void onFoodBowlUpdated(int fullness);
    }
}
