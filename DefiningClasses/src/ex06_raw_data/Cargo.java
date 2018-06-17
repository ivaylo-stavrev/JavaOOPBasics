package ex06_raw_data;

public class Cargo {
    private int weight;
    private String type;

    public Cargo() { }

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

}
