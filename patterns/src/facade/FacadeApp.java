package facade;

public class FacadeApp {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.copy();
    }
}
class Computer{
    Power power = new Power();
    DVDRom dvd = new DVDRom();
    HDD hdd = new HDD();
    void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}
class Power{
    void on(){
        System.out.println("computer on");
    }
    void off(){
        System.out.println("computer off");
    }
}
class DVDRom{
    private  boolean data = false;
    void load(){
        data = true;
    }
    void unload(){
        data = false;
    }
    boolean hasData(){
        return data;
    }
}
class HDD{
    void copyFromDVD(DVDRom dvd){
        if (dvd.hasData()){
            System.out.println("copy data from DVD");
        }else{
            System.out.println("need disk with data");
        }
    }
}
