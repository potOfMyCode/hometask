package model.entity;

public class Cucumber extends Vegetable {
    private static final String NAME = "CUCUMBER";
    public Cucumber (int calorie, int weight, int freshness){
        setCalorie(calorie);
        setWeight(weight);
        setFreshness(freshness);
    }
    public Cucumber(){
        setCalorie(25);
        setWeight(60);
        setFreshness(12);
    }
    public static String getNAME() {
        return NAME;
    }
}
