package model.makeSalad;

import model.Salads;
import model.entity.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MakeToCuCab implements MakeSalad{
    private List<Vegetable> contentOfToCuCab = new ArrayList<>();
    @Override
    public Map<Salads, List<Vegetable>> makeSalad() {
        contentOfToCuCab.add(factory.createTomato());
        contentOfToCuCab.add(factory.createCucumber());
        contentOfToCuCab.add(factory.createCabbage(95,600,10));
        salads.put(Salads.TOCUCAB, contentOfToCuCab);

        return salads;
    }

    @Override
    public String toString(){
        return "Salad name: " + Salads.TOCUCAB + "consist of: " + salads.get(Salads.TOCUCAB);
    }
}
