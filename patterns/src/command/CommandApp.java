package command;

public class CommandApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(new StartCommand(computer), new StopCommand(computer), new ResetCommand(computer));
        user.startComputer();
        user.resetComputer();
        user.stopComputer();
    }
}

interface Command{
    void execute();
}

//Receiver
class Computer{
    void start(){
        System.out.println("start");
    }
    void reset(){
        System.out.println("reset");
    }
    void stop(){
        System.out.println("stop");
    }
}

//Concrete command
class StartCommand implements Command{
    private Computer computer;
    StartCommand(Computer computer){
        this.computer = computer;
    }
    public void execute() {
        computer.start();
    }
}
//Concrete command
class ResetCommand implements Command{
    private Computer computer;
    ResetCommand(Computer computer){
        this.computer = computer;
    }
    public void execute() {
        computer.reset();
    }
}
//Concrete command
class StopCommand implements Command{
    private Computer computer;
    StopCommand(Computer computer){
        this.computer = computer;
    }
    public void execute() {
        computer.stop();
    }
}

//Invoker
class User{
    private Command start;
    private Command stop;
    private Command reset;
    User(Command start, Command stop, Command reset){
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }
    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }
}

