package ex07_car_salesman;

import java.util.HashMap;
import java.util.Map;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;
   //private Map<String, Engine> engines = new HashMap<>();

    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s:", this.model))
                .append(System.lineSeparator())
                .append(this.engine.toString())
        //System.out.printf("%s:%n", this.model);
                .append(String.format("Weight: %s", this.weight == -1 ? "n/a" : String.format("%d", this.weight)))
                .append(System.lineSeparator())
                .append(String.format("Color: %s", this.color));
        return sb.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }
}
