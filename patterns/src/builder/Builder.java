package builder;

import javax.sql.rowset.CachedRowSet;

public class Builder {
    public static void main(String[] args) {
//        Car car = new CarBuild().setMark("Mercedes")
//                //.setSpeed(280)
//                .setTransmission(Transmission.MANUAL).
//                        build();
//        System.out.println(car);

        Director director = new Director();
        director.setBuilder(new BmwBuilder());
        Car car = director.buildCar();
        System.out.println(car);
        director.setBuilder(new VazBuilder());
        car = director.buildCar();
        System.out.println(car);

    }
}

abstract class CarBuilder{
    Car car;
    void createCar(){
        car = new Car();
    }

    Car getCar() {
        return car;
    }

    abstract void setMark();
    abstract void setTransmission();
    abstract void setSpeed();
}

class BmwBuilder extends CarBuilder{
    void setMark() {
        car.setMark("BMW");
    }
    void setTransmission() {
        car.setTransmission(Transmission.AUTO);
    }
    void setSpeed() {
        car.setMaxSpeed(320);
    }
}
class VazBuilder extends CarBuilder{
    void setMark() {
        car.setMark("Vaz");
    }
    void setTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }
    void setSpeed() {
        car.setMaxSpeed(140);
    }
}

class Director{
    private CarBuilder builder;

    void setBuilder(CarBuilder builder) {
        this.builder = builder;
    }

    Car buildCar(){
        builder.createCar();
        builder.setMark();
        builder.setTransmission();
        builder.setSpeed();
        return builder.getCar();
    }
}

enum Transmission{AUTO,MANUAL}

class Car{
    private String mark;
    private Transmission transmission;
    private int maxSpeed;

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return mark + " " + transmission + " " + maxSpeed;
    }
}

//class CarBuild{
//    private String m = "default";
//    private Transmission t = Transmission.AUTO;
//    private int s= 120;
//    CarBuild setMark(String m){
//        this.m= m;
//        return this;
//    }
//    CarBuild setTransmission(Transmission t){
//        this.t= t;
//        return this;
//    }
//    CarBuild setSpeed(int s){
//        this.s= s;
//        return this;
//    }
//    Car build(){
//        Car car = new Car();
//        car.setMark(m);
//        car.setTransmission(t);
//        car.setMaxSpeed(s);
//        return car;
//    }
//}
