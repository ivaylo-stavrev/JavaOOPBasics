package ex03_wild_farm;

public class Vegetable extends Food{
    public static final String FOOD_TYPE_VEGETABLE = "Vegetable";

    public Vegetable(int quantity) {
        super(quantity, FOOD_TYPE_VEGETABLE);
    }
}
