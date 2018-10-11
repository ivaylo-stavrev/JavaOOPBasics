package entities;

public class Villain extends AntiHero {
    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (this.getIntelligence() * this.getSpecial()) / this.getEnergy();
    }
}
