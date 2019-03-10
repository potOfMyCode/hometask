package pack;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void startProgram(){
        Scanner scanner = new Scanner(System.in);
        Notebook notebook = new Notebook(scanner, view);
        notebook.inputNote();
    }




}
