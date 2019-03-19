package model.makeSalad;

import model.Salads;
import model.entity.Vegetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MakeToCu implements MakeSalad{
    private List<Vegetable> contentOfToCu = new ArrayList<>();
    @Override
    public Map<Salads, List<Vegetable>> makeSalad() {
        contentOfToCu.add(factory.createTomato());
        contentOfToCu.add(factory.createTomato(100, 150, 36));
        contentOfToCu.add(factory.createCucumber());
        salads.put(Salads.TOCU , contentOfToCu);

        return salads;
    }

    @Override
    public String toString(){
        return "Salad name: " + Salads.TOCU + "consist of: " + salads.get(Salads.TOCU);
    }
}
