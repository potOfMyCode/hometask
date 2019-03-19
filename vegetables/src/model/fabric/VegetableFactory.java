package model.fabric;

import model.entity.Vegetable;

public interface VegetableFactory {
    Vegetable createTomato();
    Vegetable createTomato(int calorie, int weight, int freshness);
    Vegetable createCucumber();
    Vegetable createCucumber(int calorie, int weight, int freshness);
    Vegetable createCarrot();
    Vegetable createCarrot(int calorie, int weight, int freshness);
    Vegetable createCabbage();
    Vegetable createCabbage(int calorie, int weight, int freshness);
}
