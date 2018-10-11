package ex02_vehicles_extension;

public abstract class Vehicle {
    private static final int REFUEL_ERR_NEGATIVE_VALUE = -1;
    private static final int REFUEL_ERR_NOT_FITTING_IN_TANK = 0;
    private static final int REFUEL_COMPLETED = 1;

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if(fuelQuantity < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    protected void setTankCapacity(double tankCapacity) {
        if(tankCapacity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.tankCapacity = tankCapacity;
    }

    protected double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    protected double getFuelConsumption() {
        return this.fuelConsumption;
    }

    protected boolean drive(double distance) {
        double neededFuel = distance * this.getFuelConsumption();
        if(neededFuel > this.getFuelQuantity()) {
            return false;
        }
        this.setFuelQuantity(this.getFuelQuantity() - neededFuel);
        return true;
    }

    protected int refuel(double liters) {
        if(liters <= 0) {
            return REFUEL_ERR_NEGATIVE_VALUE;
        }
        else if(this.getTankCapacity() < this.getFuelQuantity() + liters) {
            return REFUEL_ERR_NOT_FITTING_IN_TANK;
        }
        this.setFuelQuantity(this.getFuelQuantity() + liters);
        return REFUEL_COMPLETED;
    }

    protected boolean driveEmpty(double distance) {
        return false;
    }


    //protected abstract boolean driveEmpty(double distance);
}
