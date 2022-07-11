package com.nordlicht.best.animal;

import com.nordlicht.best.Noisy;

public abstract class Animal implements Noisy {
    private final String name;
    private final int age;
    // 100 is full, 0 is starving
    private int hunger = 100;

    private FoodBowl foodBowl;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void sleep() {
        System.out.println(name + "sleeps. Zzz...");
        depleteHunger(50);
    }

    public void run() {
        System.out.println(name + " is running around");
        depleteHunger(20);
    }

    private void depleteHunger(int hungerAmount) {
        hunger -= hungerAmount;
        if (hunger < 0) {
            hunger = 0;
        }
    }

    public void setFoodBowl(FoodBowl foodBowl) {
        this.foodBowl = foodBowl;
        foodBowl.subscribe(availableFood -> eat(foodBowl));
    }

    private void eat(Food food) {
        var amountToEat = Math.min(food.getAvailableFood(), 100 - hunger);
        System.out.println(name + " eats " + amountToEat + " food.");
        food.eat(amountToEat);
        hunger += amountToEat;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + name;
    }
}
