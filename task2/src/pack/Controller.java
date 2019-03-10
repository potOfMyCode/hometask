package pack;

import java.util.Scanner;

public class Controller{
    Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    private View view;
    private Model model;
    static int count;

    void runGame(){
        Scanner scanner = new Scanner(System.in);
        int number =  Model.X;
        int input = -1;

        view.start();

        while (input!= number) {
            do {
                while (!scanner.hasNextInt()) {
                    view.error();
                    scanner.next();
                }
                input = scanner.nextInt();
                if((input < 0) || (input > 100)){
                    view.error();
                }
            }while (!((input >= 0) && (input <= 100)));

            if (input == number) {
                count++;
                view.finsish(number, count);
            } else if (input < number) {
                count++;
                view.more(input);
            } else {
                count++;
                view.less(input);
            }
        }
    }
}
