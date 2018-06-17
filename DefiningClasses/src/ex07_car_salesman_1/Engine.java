package ex07_car_salesman_1;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public Engine(String model, int power, int displacement) {
        this(model, power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model, power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s:%n", this.model));
        //System.out.printf("%s:%n", this.model);
        sb.append(String.format("Power: %d%n", this.power));
        sb.append(String.format("Displacement: %s%n", this.displacement == -1 ? "n/a" : String.format("%d", this.displacement)));
        sb.append(String.format("Efficiency: %s%n", this.efficiency));
        return sb.toString();
    }
}
