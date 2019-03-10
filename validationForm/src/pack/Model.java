package pack;

import java.util.Scanner;

public class Model {
    private View view;
    private Scanner scanner;

    Model(View view, Scanner scanner){
        this.scanner = scanner;
        this.view =view;
    }
    Model(){}

    String validation(String input, String regex){
        String result;
        view.printStringInput(input , regex);
        while(!(scanner.hasNext()&&
                (result = scanner.next()).matches(regex))){
            view.printWrongInput(input);
        }
        return result;
    }
}
