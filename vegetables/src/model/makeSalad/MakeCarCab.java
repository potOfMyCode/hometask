package model.makeSalad;

import model.Salads;
import model.entity.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MakeCarCab implements MakeSalad{
    private List<Vegetable> contentOfCarCab = new ArrayList<>();

    @Override
    public Map<Salads, List<Vegetable>> makeSalad() {
        contentOfCarCab.add(factory.createCarrot());
        contentOfCarCab.add(factory.createCabbage());
        contentOfCarCab.add(factory.createCabbage(55,200,15));
        salads.put(Salads.CARCAB, contentOfCarCab);

        return salads;
    }

    @Override
    public String toString(){
        return "Salad name: " + Salads.CARCAB + "consist of: " + salads.get(Salads.CARCAB);
    }
}
