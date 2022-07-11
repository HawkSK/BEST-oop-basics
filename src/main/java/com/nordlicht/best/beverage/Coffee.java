package com.nordlicht.best.beverage;

public class Coffee {
    public Coffee(CoffeeBeans beans, Water water) {
        System.out.println("Coffee is ready.");
    }

    public Coffee(CoffeeBeans beans, Water water, Milk milk) {
        System.out.println("Coffee with milk is ready.");
    }
}
