package com.nordlicht.best.beverage;

import com.nordlicht.best.Noisy;

public class CappuccinoMaker implements CoffeeMachine, Noisy {
    private final Mill mill;
    private final Steamer steamer;

    private CoffeeBeans coffeeBeans;
    private Water water;
    private Milk milk;

    public CappuccinoMaker(Mill mill, Steamer steamer) {
        this.steamer = steamer;
        this.mill = mill;
    }


    @Override
    public Coffee brewCoffee() {
        checkIngredients();
        mill.mill(coffeeBeans);
        steamer.heat(water);
        steamer.heat(milk);
        System.out.println("Brewing cappuccino...");
        makeNoise();
        return new Coffee(coffeeBeans, water, milk);
    }

    private void checkIngredients() {
        if (coffeeBeans == null) {
            throw new IllegalStateException("Coffee beans are missing!");
        } else if (water == null) {
            throw new IllegalStateException("Water is missing!");
        } else if (milk == null) {
            throw new IllegalStateException("Milk is missing!");
        }
    }

    @Override
    public void setMilk(Milk milk) {
        this.milk = milk;
    }

    @Override
    public void setWater(Water water) {
        this.water = water;
    }

    @Override
    public void setCoffeeBeans(CoffeeBeans coffeeBeans) {
        this.coffeeBeans = coffeeBeans;
    }

    @Override
    public void makeNoise() {
        System.out.println("Bzzzt");
    }
}
