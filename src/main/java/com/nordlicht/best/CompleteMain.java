package com.nordlicht.best;

import com.nordlicht.best.animal.AAnimal;
import com.nordlicht.best.animal.Cat;
import com.nordlicht.best.animal.Chihuahua;
import com.nordlicht.best.animal.Dog;
import com.nordlicht.best.animal.FoodBowl;
import com.nordlicht.best.beverage.CappuccinoMaker;
import com.nordlicht.best.beverage.CoffeeBeans;
import com.nordlicht.best.beverage.CoffeeMachine;
import com.nordlicht.best.beverage.Milk;
import com.nordlicht.best.beverage.Mill;
import com.nordlicht.best.beverage.Steamer;
import com.nordlicht.best.beverage.Water;
import com.nordlicht.best.car.Car;
import com.nordlicht.best.car.Engine;

public class CompleteMain {
    public static void main(String[] args) {
        System.out.println("\nObjects, classes\n");

        Dog lassie = new Dog("Lassie", 10);
        System.out.println(lassie.getName() + " is " + lassie.getAge() + " years old.");

//        encapsulation();

        AAnimal buddy = new Dog("Buddy", 5);
        AAnimal rambo = new Chihuahua("Rambo", 2);

//        polymorphism(buddy, rambo);

//        abstraction();

//        singletonPattern(buddy, rambo);

        observerPattern(buddy, rambo);
    }

    private static void polymorphism(AAnimal buddy, AAnimal rambo) {
        System.out.println("\nPolymorphism\n");

        // overriding
        buddy.makeNoise();
        rambo.makeNoise();
        Noisy machine = new CappuccinoMaker(new Mill(), new Steamer());
        machine.makeNoise();
        Noisy car = new Car(new Engine());
        car.makeNoise();

        // overloading
        final var steamer = new Steamer();
        steamer.heat(new Milk());
        steamer.heat(new Water());
    }

    private static void abstraction() {
        System.out.println("\nAbstraction\n");

        /*CappuccinoMaker*/
        CoffeeMachine coffeeMachine = new CappuccinoMaker(new Mill(), new Steamer());
        coffeeMachine.setCoffeeBeans(new CoffeeBeans());
        coffeeMachine.setWater(new Water());
        coffeeMachine.setMilk(new Milk());
        final var coffee = coffeeMachine.brewCoffee();
    }

    private static void encapsulation() {
        System.out.println("\nEncapsulation\n");
        // lassie.name = "David";
        final var foodBowl = new FoodBowl();
//        foodBowl.fullness = 100;
        foodBowl.fill(200);
        foodBowl.eat(50);
        System.out.println(foodBowl.getAvailableFood());
        foodBowl.fill(42);
        System.out.println(foodBowl.getAvailableFood());
    }

    private static void singletonPattern(AAnimal buddy, AAnimal rambo) {
        System.out.println("\nSingleton pattern\n");

        World.getInstance().addAnimal(buddy);
        World.getInstance().addAnimal(rambo);
        World.getInstance().addAnimal(new Cat("Tom", 3));

        System.out.println("World contains:" + World.getInstance().getAnimals());
    }

    private static void observerPattern(AAnimal buddy, AAnimal rambo) {
        System.out.println("\nObserver pattern\n");

        final var foodBowl = new FoodBowl();
        buddy.setFoodBowl(foodBowl);
        buddy.run(); // -25
        buddy.sleep(); // -50

        rambo.setFoodBowl(foodBowl);
        rambo.run(); // -25
        rambo.run(); // -25

        foodBowl.fill(35);
        System.out.println("second fill");
        foodBowl.fill(100);
    }
}