package com.company;

public class Car {
    private String model;
    private String type;

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }

    @Override
    public String toString() {
        return model + " - " + type;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }
}
