package models.characters;

public class Endurance extends Characters {
    private static final double ENDURANCE_RESISTANCE_COEFICIENT = 0.4;
    private static final double ENDURANCE_DEFENSE_FATIGUE_COEFICIENT = 0.60;

    private double magicResistance;

    public Endurance(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.magicResistance = magicka * ENDURANCE_RESISTANCE_COEFICIENT;
    }

    @Override
    public double getOffense() {
        return this.getFatigue();
    }

    @Override
    public double getDefense() {
        return this.getHealth() + this.getFatigue() * ENDURANCE_DEFENSE_FATIGUE_COEFICIENT + this.magicResistance;
    }

    @Override
    public String toString() {
        StringBuilder enduranceSB = new StringBuilder();
        enduranceSB.append(System.lineSeparator())
                .append("#Endurance bonuses:")
                .append(System.lineSeparator())
                .append(String.format("Magic resistance: +%.2f defense.", this.magicResistance));
        return super.toString() + enduranceSB.toString();
    }
}
