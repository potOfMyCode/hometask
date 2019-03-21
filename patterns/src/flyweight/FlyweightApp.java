package flyweight;

import java.util.*;

public class FlyweightApp {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        ShapeFactory shapeFactory = new ShapeFactory();

        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("square"));
        shapes.add(shapeFactory.getShape("circle"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("point"));
        shapes.add(shapeFactory.getShape("square"));

        Random rand = new Random();
        for(Shape s: shapes){
            int x = rand.nextInt(100);
            int y = rand.nextInt(100);
            s.draw(x,y);
        }
    }
}
interface Shape{
    void draw(int x, int y);
}
class Point implements Shape{
    public void draw(int x, int y) {
        System.out.println("This is shape with x: " + x + " and y: "+ y);
    }
}
class Circle implements Shape{
    public void draw(int x, int y) {
        int r = 5;
        System.out.println("This is circle with x: " + x + " and y: "+ y + ", with radius = "+ r);
    }
}
class Square implements Shape{
    public void draw(int x, int y) {
        int a = 10;
        System.out.println("This is square with x: " + x + " and y: "+ y + ", with side = "+ a);
    }
}

class ShapeFactory{
    private final static Map<String, Shape> shapes = new HashMap<>();
    Shape getShape(String name){
        Shape shape = shapes.get(name);
        if(shape == null){
            if(name.equals("circle"))
                shape = new Circle();
            if(name.equals("square"))
                shape = new Square();
            if(name.equals("point"))
                shape = new Point();
            shapes.put(name, shape);
        }
        return shape;
    }
}