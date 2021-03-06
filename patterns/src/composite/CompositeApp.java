package composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square1 = new Square();
        Shape square2 = new Square();
        Shape triangle1 = new Triangle();

        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape triangle3 = new Triangle();

        Composite composite = new Composite();
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        composite1.addComponent(square1);
        composite1.addComponent(square2);
        composite1.addComponent(triangle1);

        composite2.addComponent(circle1);
        composite2.addComponent(circle2);
        composite2.addComponent(triangle3);

        composite.addComponent(composite1);
        composite.addComponent(composite2);
        composite.addComponent(new Square());

        composite.draw();;
    }
}

interface Shape{
    void draw();
}

class Square implements Shape{
    public void draw() {
        System.out.println("Square");
    }
}
class Triangle implements Shape{
    public void draw() {
        System.out.println("Triangle");
    }
}
class Circle implements Shape{
    public void draw() {
        System.out.println("Circle");
    }
}

class Composite implements Shape{
    private List<Shape> component = new ArrayList<>();
    void addComponent(Shape s){
        component.add(s);
    }
    void removeComponent(Shape s){
        component.remove(s);
    }
    public void draw(){
        for(Shape c: component){
            c.draw();
        }
    }
}