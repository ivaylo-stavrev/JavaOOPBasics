package entities;

import contracts.SuperPower;

public class Power implements SuperPower {
    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.name = name;
        this.powerPoints = powerPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if((name.length() < 5) || (!name.matches("@\\w+@"))) {
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }
        this.setName(name);
    }

    @Override
    public double getPowerPoints() {
        return this.powerPoints;
    }

    public void setPowerPoints(double powerPoints) {
        if(powerPoints < 0) {
            throw new IllegalArgumentException("Power points should be a possitive number!");
        }
        this.setPowerPoints(powerPoints);
    }
}
