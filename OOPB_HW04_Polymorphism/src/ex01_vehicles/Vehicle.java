package ex01_vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    protected static final DecimalFormat df = new DecimalFormat("#.##");

    private double fuelQuantity;
    private double fuelConsumption;

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public abstract void drive(double distance);

    public abstract void refuel(double liters);
}
