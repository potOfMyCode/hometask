package model.entity;

public abstract class Vegetable {
    private int calorie;
    private int weight;
    private int freshness;

    public int getCalorie() {
        return calorie;
    }

    public int getWeight() {
        return weight;
    }

    public int getFreshness() {
        return freshness;
    }

    void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    void setWeight(int weight) {
        this.weight = weight;
    }

    void setFreshness(int freshness) {
        this.freshness = freshness;
    }

    @Override
    public String toString(){
        return "Name: " + getClass().getSimpleName() + ", calorie: " + calorie + ", weight: " + weight + ", freshness in hour: " + freshness+"\n";
    }

    @Override
    public int hashCode(){
        return (calorie*31 + weight)*31 + freshness;
    }
}
