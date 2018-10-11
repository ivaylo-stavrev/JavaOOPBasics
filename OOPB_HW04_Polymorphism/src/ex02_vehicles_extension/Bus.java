package ex02_vehicles_extension;

public class Bus extends Vehicle {
    private static final double BUS_AC_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + BUS_AC_CONSUMPTION);
    }

    private void setFuelConsumptionEmpty() {
        super.setFuelConsumption(this.getFuelConsumption() - BUS_AC_CONSUMPTION);
    }

    @Override
    protected boolean driveEmpty(double distance) {
        boolean result;
        this.setFuelConsumptionEmpty();
        result = super.drive(distance);
        this.setFuelConsumption(this.getFuelConsumption());
        return result;
    }
}
