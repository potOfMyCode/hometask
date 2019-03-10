package pack;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view ;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    Scanner scanner = new Scanner(System.in);

    void runController(){
        view.hello_request();
        String hello = scanner.nextLine();

        while(!isCorrectHello(hello)) {
            view.error();
            hello = scanner.nextLine();
        }

        model.setText(hello);

        view.world_request();
        String world = scanner.nextLine();

        while(!isCorrectWorld(world)){
            view.error();
            world = scanner.nextLine();
        }

        model.setText(" " + world);
        view.success(model.getText());
    }

    boolean isCorrectHello(String str){
        str = str.toLowerCase();
        return str.equals("hello");
    }

    boolean isCorrectWorld(String str){
        str = str.toLowerCase();
        return str.equals("world!");
    }
}
