package model.makeSalad;

import model.Salads;
import model.entity.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MakeToCuCarCab implements MakeSalad{
    private List<Vegetable> contentOfToCuCarCab = new ArrayList<>();

    @Override
    public Map<Salads, List<Vegetable>> makeSalad() {
        contentOfToCuCarCab.add(factory.createTomato());
        contentOfToCuCarCab.add(factory.createCucumber());
        contentOfToCuCarCab.add(factory.createCarrot(15,25,6));
        contentOfToCuCarCab.add(factory.createCabbage(75,400,26));
        salads.put(Salads.TOCUCARCAB, contentOfToCuCarCab);

        return salads;
    }

    @Override
    public String toString(){
        return "Salad name: " + Salads.TOCUCARCAB + "consist of: " + salads.get(Salads.TOCUCARCAB);
    }
}
