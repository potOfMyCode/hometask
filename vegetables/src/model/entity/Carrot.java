package model.entity;

public class Carrot extends Vegetable {
    private static final String NAME = "CARROT";

    public Carrot (int calorie, int weight, int freshness){
        setCalorie(calorie);
        setWeight(weight);
        setFreshness(freshness);
    }
    public Carrot(){
        setCalorie(10);
        setWeight(40);
        setFreshness(12);
    }

    public static String getNAME() {
        return NAME;
    }
}
