package bridge;

public class BridgeApp {
    public static void main(String[] args) {
        Car car = new Cabriolet(new Mercedes());
        car.showDetails();
    }
}
abstract class Car{
    private Mark mark;
    Car(Mark mark){
        this.mark = mark;
    }
    void showDetails(){
       showType();
       mark.setMark();
    }
    abstract void showType();
}
class Sedan extends Car{
    Sedan(Mark mark) {
        super(mark);
    }
    void showType() {
        System.out.println("Sedan");
    }
}
class Cabriolet extends Car{
    Cabriolet(Mark mark) {
        super(mark);
    }
    void showType() {
        System.out.println("Cabriolet");
    }
}
class Jeep extends Car{
    Jeep(Mark mark) {
        super(mark);
    }
    void showType() {
        System.out.println("Jeep");
    }
}

interface Mark{
    void setMark();
}
class Bmw implements Mark{
    public void setMark() {
        System.out.println("BMW");
    }
}
class Mercedes implements Mark{
    public void setMark() {
        System.out.println("Mercedes");
    }
}
class Kia implements Mark{
    public void setMark() {
        System.out.println("KIA");
    }
}
