package ex05_border_control;

public class Citizen implements Indexable {
    private String name;
    private String age;
    private String id;

    public Citizen(String name, String age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
