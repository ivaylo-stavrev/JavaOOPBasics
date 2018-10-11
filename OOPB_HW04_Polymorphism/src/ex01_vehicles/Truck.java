package ex01_vehicles;

public class Truck extends Vehicle {
    private static final double TRUCK_AC_CONSUMPTION = 1.6;
    private static final double TRUCK_LEAKAGE_CORRECTION = 0.95;


    public Truck(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    public void drive(double distance) {
        double tripConsumption = distance * (this.getFuelConsumption() + TRUCK_AC_CONSUMPTION);
        if(tripConsumption < this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - tripConsumption);
            System.out.printf("Truck travelled %s km%n", df.format(distance));
        }
        else {
            System.out.println("Truck needs refueling");
        }
    }

    public void refuel(double liters) {
        this.setFuelQuantity(TRUCK_LEAKAGE_CORRECTION * liters + this.getFuelQuantity());
    }
}
