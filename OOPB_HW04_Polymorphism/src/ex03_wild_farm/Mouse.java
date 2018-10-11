package ex03_wild_farm;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, double animalWeight, String livingRegion){
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    protected void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    protected void eat(Food food) {
        if("Meat".equals(food.getFoodType())) {
            System.out.printf("Mice are not eating that type of food!%n");
        } else {
            this.setFoodEaten(this.getFoodEaten() + food.getQuantity());
        }
    }
}
