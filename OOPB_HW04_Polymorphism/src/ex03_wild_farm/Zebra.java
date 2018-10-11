package ex03_wild_farm;

public class Zebra extends Mammal {
    public Zebra(String animalName, String animalType, double animalWeight, String livingRegion){
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("Zs");
    }

    @Override
    protected void eat(Food food) {
        if("Meat".equals(food.getFoodType())) {
            System.out.printf("%ss are not eating that type of food!%n", this.getAnimalType());
        } else {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        }
    }
}
