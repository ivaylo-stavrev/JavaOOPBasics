package ex03_wild_farm;

public class Cat extends Feline {
    private String breed;

    public Cat(String animalName, String animalType, double animalWeight, String livingRegion, String breed){
        super(animalName, animalType, animalWeight, livingRegion);
        setBreed(breed);
    }

    public String getBreed() {
        return this.breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAnimalType())
                .append("[")
                .append(this.getAnimalName())
                .append(", ")
                .append(this.getBreed())
                .append(", ")
                .append(this.getAnimalWeight())
                .append(", ")
                .append(this.getLivingRegion())
                .append(", ")
                .append(this.getFoodEaten())
                .append("]");
        return sb.toString();
    }
}
