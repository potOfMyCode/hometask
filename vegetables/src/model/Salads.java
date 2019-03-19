package model;

import model.entity.*;

public enum Salads {
    TOCU("Tocu"),
    TOCUCAB("Tocucab"),
    CARCAB("Carcab"),
    TOCUCARCAB("Tocucarcab");


    private String name;

    Salads(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String toString(){
        return this.name;
    }
}
