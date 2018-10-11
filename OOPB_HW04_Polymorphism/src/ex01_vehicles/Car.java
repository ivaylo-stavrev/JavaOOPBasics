package ex01_vehicles;

public class Car extends Vehicle {
    private static final double CAR_AC_CONSUMPTION = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    @Override
    public void drive(double distance) {
        double tripConsumption = distance * (this.getFuelConsumption() + CAR_AC_CONSUMPTION);
        if(tripConsumption < this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - tripConsumption);
            System.out.printf("Car travelled %s km%n", df.format(distance));
        }
        else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void refuel(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }
}
