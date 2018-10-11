package models.areas;

import interfaces.GuildIf;
import interfaces.Hero;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Guild implements GuildIf {
    private String name;
    private Map<String, Hero> heroes = new LinkedHashMap<>();
    private long guildSize;

    public Guild(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String addHero(Hero hero) {
        if (heroes.containsKey(hero.getName())) {
            return String.format("Hero already exists.");
        }
        heroes.put(hero.getName(), hero);
        guildSize++;
        return String.format("Added hero: %s", hero.getName());

    }

    @Override
    public String removeHero(Hero hero) {
        if (!heroes.containsKey(hero.getName())) {
            return String.format("No such hero in this guild!");
        }
        heroes.remove(hero.getName());
        guildSize--;
        return String.format("Successfully removed hero [%s] from guild %s", hero.getName(), this.getName());
    }

    @Override
    public Hero getHeroByName(String heroName) {
        if (heroes.containsKey(heroName)) {
            return heroes.get(heroName);
        } else {
            return null;
        }
    }

    @Override
    public Long getGuildSize() {
        return this.guildSize;
    }

    @Override
    public double getGuildPower() {
        double result = 0;
        for (Hero hero : heroes.values()) {
            result += hero.getTotalPoints();
        }
        return result;
    }

    @Override
    public String getGuildSpecialization() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder guildSB = new StringBuilder();
        guildSB.append(String.format("##Guild: Name: %s, Power: %.2f, Size: %d", this.name, this.getGuildPower(), this.getGuildSize()));
        return guildSB.toString();
    }

    public String heroesToString() {
        StringBuilder heroesSB = new StringBuilder();
        for (Hero hero : heroes.values()) {
            heroesSB.append(System.lineSeparator())
                    //append(hero.toString());
                    .append(String.format("Hero: %s, Offense: %.2f, Defense: %.2f", hero.getName(), hero.getOffense(), hero.getDefense()));
        }
        return heroesSB.toString();
    }
}
