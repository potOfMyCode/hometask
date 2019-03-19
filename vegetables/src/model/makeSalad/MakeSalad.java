package model.makeSalad;

import model.Salads;
import model.entity.Vegetable;
import model.fabric.VegetableCreator;
import model.fabric.VegetableFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MakeSalad {
    Map<Salads, List<Vegetable>> salads = new HashMap<>();

    VegetableFactory factory = new VegetableCreator();

    Map<Salads, List<Vegetable>> makeSalad();

    String toString();
}
