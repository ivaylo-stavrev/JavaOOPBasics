package ex06_raw_data;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tires = new ArrayList<>();

    public Car(String model, int speed, int power, int weight, String type, double pressure1, int age1, double pressure2, int age2, double pressure3, int age3, double pressure4, int age4) {
        this.model = model;
        this.engine = new Engine(speed, power);
        this.cargo = new Cargo(weight, type);
        this.tires.add(new Tire(pressure1, age1));
        this.tires.add(new Tire(pressure2, age2));
        this.tires.add(new Tire(pressure3, age3));
        this.tires.add(new Tire(pressure4, age4));
    }

    public String getModel() {
        return this.model;
    }

    public Engine getEngine() {
        return this.engine;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public void printModel(){
        System.out.println(this.model);
    }

    public boolean isTirePressureUnderOne() {
        boolean result = false;
        for (Tire tire : tires) {
            if(tire.getPressure() < 1) {
                result = true;
                break;
            }
        }
        return result;
    }
}
