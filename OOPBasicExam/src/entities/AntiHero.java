package entities;

public abstract class AntiHero extends ComicCharacterImpl {
    private double evilness;

    public AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    public double getEvilness() {
        return this.evilness;
    }

    protected void setEvilness(double evilness) {
        if(evilness < 0) {
            throw new IllegalArgumentException("Evilness should be a possitive number!");
        }
        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.getEvilness();
    }
}
