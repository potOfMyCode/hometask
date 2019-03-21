package visitor;

public class VisitorApp {
    public static void main(String[] args) {
//        BodyElement bodyElement = new BodyElement();
//        EngineElement engineElement = new EngineElement();
//
//        Visitor hooligan = new HooliganVisitor();
//        bodyElement.accept(hooligan);
//        engineElement.accept(hooligan);
//
//        System.out.println();
//
//        Visitor mechanic = new MechanicVisitor();
//        bodyElement.accept(mechanic);
//        engineElement.accept(mechanic);

        Car car = new Car();
        car.accept(new HooliganVisitor());
        System.out.println();
        car.accept(new MechanicVisitor());
    }
}
interface Visitor{
    void visit(EngineElement engine);
    void visit(BodyElement body);
    void visit(WheelElement wheelElement);
    void visit(Car car);
}
interface Element{
    void accept(Visitor visitor);
}
class EngineElement implements Element{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class BodyElement implements Element{
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class WheelElement implements Element{
    private String name;
    WheelElement(String name){
        this.name = name;
    }
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    String getName() {
        return name;
    }
}
class Car implements Element{
    private Element[] elements;
    Car(){
        this.elements = new Element[]{new WheelElement("left up"), new WheelElement("right up"), new WheelElement("left down"),
                new WheelElement("right down"), new BodyElement(), new EngineElement()};
    }
    public void accept(Visitor visitor) {
        for(Element e : elements)
            e.accept(visitor);
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor{
    public void visit(EngineElement engine) {
        System.out.println("Завел двигатель");
    }

    public void visit(BodyElement body) {
        System.out.println("Постучал по корпусу");
    }

    public void visit(WheelElement wheelElement) {
        System.out.println("Пнул "+ wheelElement.getName() + " колесо");
    }

    public void visit(Car car) {
        System.out.println("Покурил в салоне");
    }
}
class MechanicVisitor implements Visitor{
    public void visit(EngineElement engine) {
        System.out.println("Перебрал двигатель");
    }

    public void visit(BodyElement body) {
        System.out.println("Отполировал корпус");
    }
    public void visit(WheelElement wheelElement) {
        System.out.println("Подкачал "+ wheelElement.getName() + " колесо");
    }

    public void visit(Car car) {
        System.out.println("Помыл салоне");
    }
}