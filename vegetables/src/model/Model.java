package model;

import model.entity.Vegetable;
import model.makeSalad.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Model {

    private Map<Salads, List<Vegetable>> salads;

    public void makeSalads(){
        List<MakeSalad> listOfSalad = Arrays.asList(new MakeToCu(), new MakeToCuCab(), new MakeCarCab(), new MakeToCuCarCab());
        for(MakeSalad salad: listOfSalad)
            salads = salad.makeSalad();
    }

    public Map<Salads, List<Vegetable>> getSalads() {
        return salads;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
