package controller;

import controller.exception.IncorrectInputException;
import model.Salads;
import model.entity.Vegetable;
import view.View;
import view.ViewPrompts;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static view.ViewPrompts.*;

class ControllerUtil{

    private View view;


    ControllerUtil(View view){
        this.view = view;
    }

    private List<Vegetable> sortByCalorie(List<Vegetable> list) {
        return list.stream().sorted(Comparator.comparingInt(Vegetable::getCalorie)).collect(Collectors.toList());
    }
    private List<Vegetable> sortByWeight(List<Vegetable> list) {
        return list.stream().sorted(Comparator.comparingInt(Vegetable::getWeight)).collect(Collectors.toList());
    }
    private List<Vegetable> sortByFreshness(List<Vegetable> list) {
        return list.stream().sorted(Comparator.comparingInt(Vegetable::getFreshness)).collect(Collectors.toList());
    }
    private List<Vegetable> filterByCalorie(List<Vegetable> list, int min, int max) {
        return list.stream().filter(o->o.getCalorie()>min&&o.getCalorie()<max).collect(Collectors.toList());
    }
    private List<Vegetable> filterByWeight(List<Vegetable> list, int min, int max) {
        return list.stream().filter(o->o.getWeight()>min&&o.getWeight()<max).collect(Collectors.toList());
    }
    private List<Vegetable> filterByFreshness(List<Vegetable> list, int min, int max) {
        return list.stream().filter(o->o.getFreshness()>min&&o.getFreshness()<max).collect(Collectors.toList());
    }

    void doSort(Map<Salads, List<Vegetable>> startMap, String s) throws IncorrectInputException{
        boolean flag= true;
        int min = 0;
        int max = 0;
        if(s.equals("1f")||s.equals("2f")||s.equals("3f")) {
            min = filterMinimum();
            max = filterMaximum();
        }
        for(Map.Entry<Salads, List<Vegetable>> entry: startMap.entrySet()) {
            List<Vegetable> ingredient = entry.getValue();
            if (s.equals("1")) {
                entry.setValue(sortByCalorie(ingredient));
                flag = false;
            }
            if (s.equals("2")) {
                entry.setValue(sortByWeight(ingredient));
                flag = false;
            }
            if (s.equals("3")) {
                entry.setValue(sortByFreshness(ingredient));
                flag = false;
            }
            if (s.equals("1f")) {
                entry.setValue(filterByCalorie(ingredient, min, max));
                flag = false;
            }
            if (s.equals("2f")) {
                entry.setValue(filterByWeight(ingredient, min, max));
                flag = false;
            }
            if (s.equals("3f")) {
                entry.setValue(filterByFreshness(ingredient, min, max));
                flag = false;
            }
            if (s.equals("exit"))
                System.exit(1);
        }
        if(flag){
                throw new IncorrectInputException(View.bundle.getString(INCORRECT_INPUT));
        }
    }

    void countSum(Map<Salads, List<Vegetable>> startMap){
        for(Map.Entry<Salads, List<Vegetable>> entry: startMap.entrySet()) {
            List<Vegetable> list = entry.getValue();
            List<Integer> l = list.stream().map(Vegetable::getCalorie).collect(Collectors.toList());

            view.printMessage(View.bundle.getString(SUM_CALORIE), entry.getKey().toString(), " is: " +
                    l.stream().flatMapToInt(IntStream::of).sum());
        }
    }

    private int filterMinimum(){
        Scanner scanner = new Scanner(System.in);
        int min;
        view.printMessage(View.bundle.getString(SET_BOUNDARY));
        view.printMessage(View.bundle.getString(MIN_BOUNDARY));

        while (!scanner.hasNextInt()) {
            view.printMessage(View.bundle.getString(INCORRECT_INPUT));
            scanner.next();
        }
        min = scanner.nextInt();

        return min;
    }
    private int filterMaximum(){
        Scanner scanner = new Scanner(System.in);
        int max;

        view.printMessage(View.bundle.getString(MAX_BOUNDARY));
        while (!scanner.hasNextInt()) {
            view.printMessage(View.bundle.getString(INCORRECT_INPUT));
            scanner.next();
        }
        max = scanner.nextInt();
        return max;
    }

}
