package models.characters;

import interfaces.Hero;

public abstract class Characters implements Hero {
    private String name;
    private int magicka;
    private int fatigue;
    private int health;
    private String heroType;

    public Characters(String name, int magicka, int fatigue, int health, String heroType) {
        this.name = name;
        this.magicka = magicka;
        this.fatigue = fatigue;
        this.health = health;
        this.heroType = heroType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    //TODO: Check if the encapsulation type should be different!
    protected int getMagicka() {
        return magicka;
    }

    protected int getFatigue() {
        return fatigue;
    }

    @Override
    public double getTotalPoints() {
        return this.getOffense() + this.getDefense();
    }

    @Override
    public boolean isDead() {
        if (this.health < 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void attack(Hero hero) {
        hero.receiveDamage(this.getOffense());
    }

    @Override
    public void receiveDamage(double amount) {
        this.health -= amount;
    }

    private void setMagicka(int magicka) {
        if (magicka < 1) {
            throw new IllegalArgumentException("Invalid character stats!");
        }
        this.magicka = magicka;
    }

    private void setFatigue(int fatigue) {
        if (fatigue < 1) {
            throw new IllegalArgumentException("Invalid character stats!");
        }
        this.fatigue = fatigue;
    }

    private void setHealth(int health) {
        if (health < 1) {
            throw new IllegalArgumentException("Invalid character stats!");
        }
        this.health = health;
    }

    @Override
    public String toString() {
        StringBuilder heroSB = new StringBuilder();
        heroSB.append(String.format("Hero: %s, Type: [%s]", this.getName(), this.heroType))
                .append(System.lineSeparator())
                .append("#Stats: ")
                .append(System.lineSeparator())
                .append(String.format("Health: %d", this.getHealth()))
                .append(System.lineSeparator())
                .append(String.format("Fatigue: %d", this.getFatigue()))
                .append(System.lineSeparator())
                .append(String.format("Magicka: %d", this.getMagicka()));
                //.append(System.lineSeparator())
        return heroSB.toString();
    }
}
