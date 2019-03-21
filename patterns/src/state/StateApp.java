package state;

public class StateApp {
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setStation(new Radio7());
        for(int i=0; i<10;i++){
            radio.play();
            radio.next();
        }

        System.out.println();

        Human human = new Human();
        human.setState(new Work());
        for(int i=0; i<10;i++)
            human.doSomething();

    }
}
interface RadioStation{
    void play();
}
class Radio7 implements RadioStation{
    public void play() {
        System.out.println("Radio7 play...");
    }
}
class Radio8 implements RadioStation{
    public void play() {
        System.out.println("Radio8 play...");
    }
}
class Radio9 implements RadioStation{
    public void play() {
        System.out.println("Radio9 play...");
    }
}
class Radio{
    private RadioStation station;

    void setStation(RadioStation station) {
        this.station = station;
    }

    void next(){
        if(station instanceof Radio7)
            setStation(new Radio8());
        else if(station instanceof Radio8)
            setStation(new Radio9());
        else if(station instanceof Radio9)
            setStation(new Radio7());
    }
    void play(){
        station.play();
    }
}

class Human{
    private Activity state;

    void setState(Activity state) {
        this.state = state;
    }
    void doSomething(){
        state.doSomething(this);
    }
}
interface Activity{
    void doSomething(Human h);
}
class Work implements Activity{
    public void doSomething(Human h) {
        System.out.println("Work!!!");
        h.setState(new Weekend());
    }
}
class Weekend implements Activity{
    private int count =0;
    public void doSomething(Human h) {
        if(count<3){
            System.out.println("relax...");
            count++;
        }else{
            h.setState(new Work());
            h.doSomething();
        }
    }
}