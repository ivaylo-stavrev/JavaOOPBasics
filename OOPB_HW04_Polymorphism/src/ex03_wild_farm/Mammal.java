package ex03_wild_farm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{
    DecimalFormat df = new DecimalFormat("#.##");
    private String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion){
        super(animalName, animalType, animalWeight);
        setLivingRegion(livingRegion);
    }

    protected String getLivingRegion() {
        return this.livingRegion;
    }

    protected void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getAnimalType())
                .append("[")
                .append(this.getAnimalName())
                .append(", ")
                .append(df.format(this.getAnimalWeight()))
                .append(", ")
                .append(this.getLivingRegion())
                .append(", ")
                .append(this.getFoodEaten())
                .append("]");
        return sb.toString();
    }
}
