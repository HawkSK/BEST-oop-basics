package com.nordlicht.best.beverage;

public interface CoffeeMachine {
    Coffee brewCoffee();

    void setMilk(Milk milk);

    void setWater(Water water);

    void setCoffeeBeans(CoffeeBeans coffeeBeans);
}
