package model.fabric;

import model.entity.*;

public class VegetableCreator implements VegetableFactory{
    @Override
    public Vegetable createTomato() {
        return new Tomato();
    }

    @Override
    public Vegetable createTomato(int calorie, int weight, int freshness) {
        return new Tomato(calorie, weight, freshness);
    }

    @Override
    public Vegetable createCucumber() {
        return new Cucumber();
    }

    @Override
    public Vegetable createCucumber(int calorie, int weight, int freshness) {
        return new Cucumber(calorie, weight, freshness);
    }

    @Override
    public Vegetable createCarrot() {
        return new Carrot();
    }

    @Override
    public Vegetable createCarrot(int calorie, int weight, int freshness) {
        return new Carrot(calorie, weight, freshness);
    }

    @Override
    public Vegetable createCabbage() {
        return new Cabbage();
    }

    @Override
    public Vegetable createCabbage(int calorie, int weight, int freshness) {
        return new Cabbage(calorie, weight, freshness);
    }
}
