package model.entity;

public class Cabbage extends Vegetable {
    private static final String NAME = "CABBAGE";
    public Cabbage (int calorie, int weight, int freshness){
        setCalorie(calorie);
        setWeight(weight);
        setFreshness(freshness);
    }
    public Cabbage(){
        setCalorie(90);
        setWeight(400);
        setFreshness(12);
    }
    public static String getNAME() {
        return NAME;
    }
}
