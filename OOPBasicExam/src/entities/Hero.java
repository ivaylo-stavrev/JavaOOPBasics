package entities;

public abstract class Hero extends ComicCharacterImpl {
    private double heroism;

    public Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    public double getHeroism() {
        return this.heroism;
    }

    protected void setHeroism(double heroism) {
        if(heroism < 0) {
            throw new IllegalArgumentException("Heroism should be a possitive number!");
        }
        this.heroism = heroism;
    }

    @Override
    public double getSpecial() {
        return this.getHeroism();
    }
}
