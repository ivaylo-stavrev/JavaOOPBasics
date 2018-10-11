package models.characters;

public class Strength extends Characters {
    private static final double STRENGTH_DAMAGE_COEFICIENT = 0.5;
    private static final double STRENGTH_OFFENSE_FATIGUE_COEFICIENT = 1.25;
    private static final double STRENGTH_OFFENSE_HEALTH_COEFICIENT = 0.30;
    private static final double STRENGTH_DEFENSE_FATIGUE_COEFICIENT = 0.10;

    private double magicDamage;


    public Strength(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);

        this.magicDamage = magicka * STRENGTH_DAMAGE_COEFICIENT;
    }

    @Override
    public double getOffense() {
        return this.getFatigue() * STRENGTH_OFFENSE_FATIGUE_COEFICIENT + this.getHealth() * STRENGTH_OFFENSE_HEALTH_COEFICIENT + this.magicDamage;
    }

    @Override
    public double getDefense() {
        return this.getHealth() + this.getFatigue() * STRENGTH_DEFENSE_FATIGUE_COEFICIENT;
    }

    @Override
    public String toString() {
        StringBuilder strengthSB = new StringBuilder();
        strengthSB.append(System.lineSeparator())
                .append("#Strength bonuses:")
                .append(System.lineSeparator())
                .append(String.format("Magic damage: +%.2f offense.", this.magicDamage));
        return super.toString() + strengthSB.toString();
    }
}
