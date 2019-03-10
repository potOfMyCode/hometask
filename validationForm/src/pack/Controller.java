package pack;

import java.util.Arrays;
import java.util.Scanner;
import exception.IllegalLogin;

public class Controller {
    private Model model;
    private View view;
    private Notebook notebook = new Notebook();

    Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void startProgram(){
        Scanner ownScanner = new Scanner(System.in);
        String userIn;
        do {
            Scanner scanner = new Scanner(System.in);
            Record record = new Record(scanner, view);
            record.inputNote(notebook);
            notebook.addRecord(record);
            view.registerUser();
            userIn = ownScanner.next();
        }while(!userIn.equals("no"));
        view.noteCheck(notebook);

    }




}
