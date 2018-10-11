package models.characters;

public class Orc extends Endurance {
    public Orc(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, "ORSIMER");
    }

    @Override
    public double getDefense() {
        return super.getDefense() + 0.10 * super.getDefense();
    }
}
