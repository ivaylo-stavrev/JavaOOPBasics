package ex03_wild_farm;

public abstract class Animal {
    String animalName;
    String animalType;
    Double animalWeight;
    int foodEaten;

    public Animal(String animalName, String animalType, double animalWeight){
        this.setAnimalName(animalName);
        this.setAnimalType(animalType);
        this.setAnimalWeight(animalWeight);
        //this.setFoodEaten(foodEaten);
    }

    public String getAnimalName() {
        return this.animalName;
    }

    public void setAnimalName(String animalName) {
        if (animalName == null || animalName.trim().isEmpty()) {
            throw new IllegalArgumentException("Animal name cannot be empty!");
        }
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return this.animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public Double getAnimalWeight() {
        return this.animalWeight;
    }

    public void setAnimalWeight(Double animalWeight) {
        if (animalWeight < 0) {
            throw new IllegalArgumentException("Animal weight cannot be negative!");
        }
        this.animalWeight = animalWeight;
    }

    public int getFoodEaten() {
        return this.foodEaten;
    }

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    protected abstract void makeSound();

    protected abstract void eat(Food food);


}
