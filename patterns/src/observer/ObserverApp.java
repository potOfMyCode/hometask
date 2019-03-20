package observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        MeteoStantion observable = new MeteoStantion();
        observable.addObserve(new ConsoleObserver());
        observable.addObserve(new FileObserver());
        observable.setData(35, 200);
        observable.setData(25, 300);
    }
}
interface Observable{
    void addObserve(Observer O);
    void removeObserver(Observer o);
    void notifyObserver();
}
interface Observer{
    void handleEvent(int temperature, int pressure);
}
class MeteoStantion implements Observable{
    private int temperature;
    private int pressure;
    void setData(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObserver();
    }
    private List<Observer> observers = new ArrayList<>();
    public void addObserve(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObserver() {
        for(Observer o: observers)
            o.handleEvent(temperature, pressure);
    }
}
class ConsoleObserver implements Observer{
    public void handleEvent(int temperature, int pressure) {
        System.out.println("The state of meteo stantion was changed; temperature:\n\t"+ temperature+" pressure: "+pressure);
    }
}
class FileObserver implements Observer{
    public void handleEvent(int temperature, int pressure) {
        File f;
        try{
            f = File.createTempFile("TempPressure", "");
            PrintWriter pw = new PrintWriter(f);
            pw.print("The state of meteo stantion was changed; temperature:\n\t"+ temperature+" pressure: "+pressure);
            pw.println();
            pw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}