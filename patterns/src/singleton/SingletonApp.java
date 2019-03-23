package singleton;

import javax.swing.*;

public class SingletonApp{
    private static final int SIZE = 1000;
    public static void main(String[] args) throws InterruptedException{
        Thread t[] = new Thread[SIZE];

//        for(int i =0; i<SIZE; i++){
//            Singleton s = Singleton.getInstance();
//        }
        for(int i =0 ; i< SIZE ; i++){
            t[i] = new Thread(new R());
            t[i].start();
        }
        for(int i =0 ; i< SIZE ; i++){
            t[i].join();
        }

    }
}
class R implements Runnable{
    @Override
    public void run() {
        Singleton.getInstance();
    }
}
class Singleton{
//    private static Singleton instance = new Singleton(); //  - ленивая инициализация
    private static volatile Singleton instance = null;
//    static Singleton getInstance(){
//        return instance;
//    }
    private Singleton(){
        System.out.println("private constructor");
    }
//    static synchronized Singleton getInstance(){
//        if (instance == null)
//            instance = new Singleton();
//        return instance;
//    }
    static Singleton getInstance(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}

