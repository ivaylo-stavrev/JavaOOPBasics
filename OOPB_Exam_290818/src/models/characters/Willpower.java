package models.characters;

public class Willpower extends Characters {
    private static final double WILLPOWER_PENETRATION_COEFICIENT = 0.2;
    private static final double WILLPOWER_OFFENSE_MAGICKA_COEFICIENT = 1.80;

    private double spellPentration;

    public Willpower(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.spellPentration = fatigue * WILLPOWER_PENETRATION_COEFICIENT;
    }

//    ?	Offense is equal to: 180% of the hero`s magicka + the hero`s spell penetration.
//    ?	Defense is equal to: the health of the hero.

    @Override
    public double getOffense() {
        return this.getMagicka() * WILLPOWER_OFFENSE_MAGICKA_COEFICIENT + this.spellPentration;
    }

    @Override
    public double getDefense() {
        return this.getHealth();
    }

    //TODO: Check if here should have override of the toString() method!
//    @Override
//    public String toString() {
//        StringBuilder willpowerSB = new StringBuilder();
//        enduranceSB.append(System.lineSeparator())
//                .append("#Endurance bonuses:")
//                .append(System.lineSeparator())
//                .append(String.format("Magic resistance: +%.2f defense.", this.magicResistance));
//        return super.toString() + enduranceSB.toString();
//    }
}
