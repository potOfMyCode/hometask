package pack;

public class View {
    void start(){
        System.out.println("The computer have a number. You need to guess it.\n" +
                "A number in the range from 0 to 100.\n" +
                "You need to write a number and the computer will say \"more\" or \"less\".");
    }

    void more(int input){
        System.out.println("X" + " > then " + input);
    }

    void less(int input){
        System.out.println("X < then "+ input);
    }

    void error(){
        System.out.println("Your input is incorrect! Please try again.");
    }

    void finsish(int x, int count){
        System.out.println("Congratulations!!! You are the winner! The number is: "+ x + "\nAttemps: "+ count);
    }
}
