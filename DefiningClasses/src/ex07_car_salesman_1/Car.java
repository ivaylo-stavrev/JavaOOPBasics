package ex07_car_salesman_1;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;
   //private Map<String, Engine> engines = new HashMap<>();

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine);
        this.weight = weight;
        this.color = color;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s:%n", this.model));
        sb.append(this.engine.toString());
        //System.out.printf("%s:%n", this.model);
        sb.append(String.format("Weight: %s%n", this.weight == -1 ? "n/a" : String.format("%d",this.weight)));
        sb.append(String.format("Color: %s", this.color));
        return sb.toString();
    }

    public void print() {
        System.out.println(this.toString());
    }
}
