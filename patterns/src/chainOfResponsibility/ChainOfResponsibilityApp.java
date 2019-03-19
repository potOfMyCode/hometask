package chainOfResponsibility;

public class ChainOfResponsibilityApp {
    public static void main(String[] args) {
        Logger logger1 = new SMSLogger(Level.ERROR);
        Logger logger2 = new FileLogger(Level.DEBUG);
        Logger logger3 = new EmailLogger(Level.INFO);
        logger1.setNext(logger2);
        logger2.setNext(logger3);

        logger1.printMessage("It's good", Level.INFO);
        logger1.printMessage("Execution of programm", Level.DEBUG);
        logger1.printMessage("It's FAIL", Level.ERROR);
    }
}

class Level{
    static final int ERROR = 1;
    static final int DEBUG = 2;
    static final int INFO = 3;
}
abstract class Logger{
    private int priority;
    private Logger next;
    Logger(int level){
        this.priority = level;
    }

    void setNext(Logger next) {
        this.next = next;
    }
    void printMessage(String message, int level) {
        if(level<=priority)
            write(message);
        if(next!=null)
            next.printMessage(message,level);
    }
    abstract void write(String message);
}

class SMSLogger extends Logger{
    SMSLogger(int priority){
        super(priority);
    }

    void write(String message){
        System.out.println("SMS: "+message);
    }
}
class FileLogger extends Logger{
    FileLogger(int priority){
        super(priority);
    }

    void write(String message){
        System.out.println("File: "+message);
    }
}
class EmailLogger extends Logger{
    EmailLogger(int priority){
        super(priority);
    }

    void write(String message){
        System.out.println("Email: "+message);
    }
}
