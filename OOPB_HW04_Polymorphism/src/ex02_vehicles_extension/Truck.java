package ex02_vehicles_extension;

public class Truck extends Vehicle {
    private static final double TRUCK_AC_CONSUMPTION = 1.6;
    private static final double TRUCK_LEAKAGE_CORRECTION = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + TRUCK_AC_CONSUMPTION);
    }

    @Override
    protected int refuel(double liters) {
        return super.refuel(liters * TRUCK_LEAKAGE_CORRECTION);
    }
}
