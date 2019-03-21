package templateMethod;

public class TemplateApp {
    public static void main(String[] args) {
        C a = new A();
        C b = new B();
        a.method();
        System.out.println();
        b.method();
    }
}
abstract class C{
    abstract void differ1();
    abstract void differ2();
    void method(){
        System.out.print("1");
        differ1();
        System.out.print("3");
        differ2();
    }
}
class A extends C{
    void differ1(){
        System.out.print("2");
    }
    void differ2(){
        System.out.print("5");
    }
}
class B extends C{
    void differ1() {
        System.out.print("4");
    }
    void differ2(){}
}
