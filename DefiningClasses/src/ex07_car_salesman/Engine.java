package ex07_car_salesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this(model, power, -1, "n/a");
    }

    public Engine(String model, int power, int displacement) {
        this(model, power, displacement, "n/a");
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power, -1, efficiency);
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s:", this.model))
                .append(System.lineSeparator())
                .append(String.format("Power: %d", this.power))
                .append(System.lineSeparator())
                .append(String.format("Displacement: %s", this.displacement == -1 ? "n/a" : String.format("%d", this.displacement)))
                .append(System.lineSeparator())
                .append(String.format("Efficiency: %s", this.efficiency))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
