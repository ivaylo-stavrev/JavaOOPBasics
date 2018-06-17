package ex06_raw_data;

public class Tire {
    private int tireNumber;
    private double pressure;
    private int age;

    public Tire() { }

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return this.pressure;
    }
}
