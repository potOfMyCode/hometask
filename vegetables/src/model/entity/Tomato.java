package model.entity;

public class Tomato extends Vegetable {
    private static final String NAME = "TOMATO";
    public Tomato (int calorie, int weight, int freshness){
        setCalorie(calorie);
        setWeight(weight);
        setFreshness(freshness);
    }
    public Tomato(){
        setCalorie(50);
        setWeight(70);
        setFreshness(12);
    }
    public static String getNAME() {
        return NAME;
    }
}
