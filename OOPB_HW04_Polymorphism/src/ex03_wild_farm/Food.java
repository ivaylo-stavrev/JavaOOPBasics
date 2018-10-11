package ex03_wild_farm;

public abstract class Food {
    protected int quantity;
    protected String foodType;

    protected Food() { }

    protected Food(int quantity, String foodType){
        this.setQuantity(quantity);
        this.setFoodType(foodType);
    }

    protected void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    protected int getQuantity() {
        return this.quantity;
    }

    public String getFoodType() {
        return this.foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
}
