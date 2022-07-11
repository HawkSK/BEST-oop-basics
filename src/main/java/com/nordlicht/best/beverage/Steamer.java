package com.nordlicht.best.beverage;

public class Steamer {

    public void heat(Milk milk) {
        System.out.println("Heating water to 80°C.");
        milk.heat(80);
    }

    public void heat(Water water) {
        System.out.println("Heating water to 98°C.");
        water.heat(98);
    }
}
