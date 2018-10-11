package entities;

import contracts.Arena;
import contracts.ComicCharacter;

import java.util.LinkedList;
import java.util.List;

public class ArenaImpl implements Arena {
    private String arenaName;
    private Integer capacity;
    private List<ComicCharacter> heroes;
    private List<ComicCharacter> antiHeroes;

    public ArenaImpl(String arenaName, Integer capacity) {
        this.arenaName = arenaName;
        this.capacity = capacity;
        this.heroes = new LinkedList<>();
        this.antiHeroes = new LinkedList<>();
    }

    @Override
    public String getArenaName() {
        return this.arenaName;
    }

    protected void setArenaName(String arenaName) {
        this.arenaName = arenaName;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    protected void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<ComicCharacter> getHeroes() {
        return this.heroes;
    }

    public List<ComicCharacter> getAntiHeroes() {
        return this.antiHeroes;
    }

    @Override
    public boolean isArenaFull() {
        if(this.heroes.size() + this.antiHeroes.size() >= this.getCapacity()) {
            return true;
        }
        return false;
    }

    @Override
    public void addHero(ComicCharacter hero) {
        this.heroes.add(hero);
    }

    @Override
    public void addAntiHero(ComicCharacter antiHero) {
        this.heroes.add(antiHero);
    }

    @Override
    public boolean fightHeroes() {
        return false;
    }
}
