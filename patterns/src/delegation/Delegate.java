package delegation;

public class Delegate {
    public static void main(String[] args) {
        Painter painter = new Painter();
        painter.setGraphics(new Triangle());
        painter.draw();
        painter.setGraphics(new Square());
        painter.draw();
        painter.setGraphics(new Circle());
        painter.draw();
    }
}
interface Graphics{
    void draw();
}

class Triangle implements Graphics{
    public void draw(){
            System.out.println("draw triangle");
        }
}

class Square implements Graphics{
    public void draw(){
            System.out.println("draw square");
        }
}

class Circle implements Graphics{
    public void draw(){
            System.out.println("draw circle");
        }
}

class Painter {
    private Graphics graphics;

    void setGraphics(Graphics g) {
        graphics = g;
    }

    void draw() {
        graphics.draw();
    }
}

