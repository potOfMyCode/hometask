package pack;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Dispatcher {
    public static void main(String[] args){
        MyClass myClass = new MyClass();
        int number = myClass.getNumber();
        String name = null; // no getter
        System.out.println(number+name);//output 0null
        try{
            Field field = myClass.getClass().getDeclaredField("name");
            field.setAccessible(true);
            field.set(myClass, (String)"new value");
            name = (String)field.get(myClass);
        }catch(NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }
//        System.out.println(number + name);//output 0default
        printData(myClass);


        //create object for constructor without parameters
//        MyClass myClass = null;
//        try{
//            Class clazz =Class.forName(MyClass.class.getName());
//            myClass=(MyClass)clazz.newInstance();
//        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException e){
//            e.printStackTrace();
//        }
//        System.out.println(myClass);//output created object pack.MyClass@677327b6

        //Create object for constructor with parameters
//        MyClass myClass = null;
//        try{
//            Class clazz = Class.forName(MyClass.class.getName());
//            Class[] params = {int.class, String.class};
//            myClass = (MyClass)clazz.getConstructor(params).newInstance(1,"default2");
//        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e){
//            e.printStackTrace();
//        }
//        System.out.println(myClass); // pack.MyClass@1540e19d
    }
    public static void printData(Object myClass){
        try{
            Method method = myClass.getClass().getDeclaredMethod("printData");
            method.setAccessible(true);
            method.invoke(myClass);
        }catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException e){
            e.printStackTrace();
        }
    }
}
