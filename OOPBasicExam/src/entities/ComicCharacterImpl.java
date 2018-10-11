package entities;

import contracts.ComicCharacter;
import contracts.SuperPower;

import java.util.LinkedList;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {
    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;
    private boolean isCurrentlyOnArena;

    public ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new LinkedList<>();
        this.setIsCurrentlyOnArena(false);
    }


    @Override
    public boolean isCurrentlyOnArena() {
        return this.isCurrentlyOnArena;
    }

    @Override
    public void setIsCurrentlyOnArena(boolean isCurrentlyOnArena) {
        this.isCurrentlyOnArena = isCurrentlyOnArena;
    }

    @Override
    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        if((name.length() > 12) || (name.length() < 2) || (!name.matches("@\\w+@"))) {
            throw new IllegalArgumentException("Comic Character name is not in the correct format!");
        }
        this.name = name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    protected void setEnergy(int energy) {
        if(energy < 0) {
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }
        this.energy = energy;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    protected void setHealth(double health) {
        if(health < 0) {
            throw new IllegalArgumentException("Health should be a possitive number!");
        }
        this.health = health;
    }

    @Override
    public double getIntelligence() {
        return this.intelligence;
    }

    protected void setIntelligence(double intelligence) {
        if((intelligence < 0) || (intelligence > 200)){
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
        this.intelligence = intelligence;
    }

    public List<SuperPower> getPowers() {
        return this.powers;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    @Override
    public String useSuperPowers() {
        if(powers.size() < 1) {
            return String.format("%s has no super powers!", this.getName());
        } else {
            for (SuperPower power : powers) {
                this.setEnergy((int)this.getEnergy() + (int)power.getPowerPoints());
                this.setHealth(this.getHealth() + power.getPowerPoints() * 2);
            }
            return String.format("%s used his super powers!", this.getName());
        }
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        powers.add(superPower);
    }

}
