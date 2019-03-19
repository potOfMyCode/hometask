package abstractFactory;

import java.security.Key;

public class AbstractFactoryApp {
    public static void main(String[] args) {
        DeviceFactory factory = getDevice("en");
        Mouse m = factory.createMouse();
        Keyboard k = factory.createKeyboard();
        m.click();
        m.scroll();
        k.print();
    }

    static DeviceFactory getDevice(String s) {
        if (s.equals("ru"))
            return new RuDeviceFactory();
        if (s.equals("en"))
            return new EnDeviceFactory();
        throw new RuntimeException("unsupportable language");
    }
}

interface Mouse{
    void click();
    void scroll();
}

interface Keyboard{
    void print();
}

class RuMouse implements Mouse{

    @Override
    public void click() {
        System.out.println("Это клик!");
    }

    @Override
    public void scroll() {
        System.out.println("Прокручиваем!");
    }
}

class EnMouse implements Mouse{

    @Override
    public void click() {
        System.out.println("This is click!");
    }

    @Override
    public void scroll() {
        System.out.println("This is scroll!");
    }
}

class RuKeyboard implements Keyboard{

    @Override
    public void print() {
        System.out.println("Нажали клавишу!");
    }
}

class EnKeyboard implements Keyboard{

    @Override
    public void print() {
        System.out.println("Press on keyboard!");
    }
}

interface DeviceFactory{
    Mouse createMouse();
    Keyboard createKeyboard();
}

class RuDeviceFactory implements DeviceFactory{

    @Override
    public Mouse createMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new RuKeyboard();
    }
}

class EnDeviceFactory implements DeviceFactory{

    @Override
    public Mouse createMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard createKeyboard() {
        return new EnKeyboard();
    }
}