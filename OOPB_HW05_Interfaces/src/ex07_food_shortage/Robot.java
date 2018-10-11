package ex07_food_shortage;

public class Robot implements Indexable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.setModel(model);
        this.setId(id);
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
