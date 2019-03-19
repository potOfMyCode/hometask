package decorator;

import org.omg.CORBA.BAD_QOS;

public class DecoratorApp {
    public static void main(String[] args) {
//        PrinterInterface printer = new Printer("Privet");
        PrinterInterface printer = new QuotesDecorator(new LeftBracketDecorator(new RightBracketDecorator(new Printer("Privet"))));
        printer.print();
    }
}

interface PrinterInterface{
    void print();
}
class Printer implements PrinterInterface{
    private String value;
    Printer(String value){
        this.value = value;
    }
    public void print() {
        System.out.print(value);
    }
}
abstract class Decorator implements PrinterInterface{
    PrinterInterface component;
    Decorator(PrinterInterface component){
        this.component = component;
    }
    public void print(){
        component.print();
    }
}
class QuotesDecorator extends Decorator{
    QuotesDecorator(PrinterInterface component){
        super(component);
    }
    public void print() {
        System.out.print("\"");
        super.print();
        System.out.println("\"");
    }
}
class LeftBracketDecorator extends Decorator{
    LeftBracketDecorator(PrinterInterface component){
        super(component);
    }
    public void print() {
        System.out.print("[");
        super.print();
    }
}
class RightBracketDecorator extends Decorator{
    RightBracketDecorator(PrinterInterface component){
        super(component);
    }
    public void print() {
        super.print();
        System.out.print("]");
    }
}
