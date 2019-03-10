package pack;

public class Main {

    public static void fire(Object sender){
        System.out.println("Lamda syntaxis");
    }

    public static void main(String[] args) {
        Switcher sw = new Switcher();
        Lamp lamp = new Lamp();
        Radio radio = new Radio();



        //event subscribe
        sw.addElectricityAListener(lamp);
        sw.addElectricityAListener(radio);

        String message = "Fire!!!";

        //create anonymus class
        sw.addElectricityAListener(
                new ElectricityConsumer() {
                    @Override
                    public void electricityOn(Object sender) {
                        System.out.println(message);
                    }
                }
        );

        sw.addElectricityAListener( (sender) -> System.out.println("Lambda expression"));
        sw.addElectricityAListener(Main::fire); // Main::fire == ()-> Main.fire()

        sw.switchOn();
    }
}
