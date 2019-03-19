package controller;

import controller.exception.IncorrectInputException;
import model.Model;
import model.Salads;
import model.entity.Vegetable;
import view.View;
import view.ViewPrompts;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static view.ViewPrompts.*;

public class Controller {
    private View view;
    private Model model;
//    private Map<Salads, List<Vegetable>> salads;

    private Scanner scanner = new Scanner(System.in);


    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void start(){
        view.printMessage(View.bundle.getString(START_DATA));
        model.makeSalads();

        view.printMapOfSalads(model.getSalads());

        ControllerUtil c =new ControllerUtil(view);

        c.countSum(model.getSalads());

        view.printMessage(View.bundle.getString(SORT_DATA));
        view.printMessage(View.bundle.getString(SORT_BY));
        while(scanner.hasNext()) {
            try {
                c.doSort(model.getSalads(), scanner.nextLine());
                view.printMapOfSalads(model.getSalads());
            }catch(IncorrectInputException inc){
                inc.printStackTrace();
            }finally {
                view.printMessage(View.bundle.getString(SORT_DATA));
                view.printMessage(View.bundle.getString(SORT_BY));
            }
        }
    }


}
