package engines;

import contracts.Arena;
import contracts.ComicCharacter;
import contracts.SuperPower;
import contracts.WarManagerIF;
import entities.*;

import java.util.*;

public class WarManager implements WarManagerIF {

    private Map<String, ComicCharacter> allCharacters;
    private Map<String, Hero> allHeroes;
    private Map<String, AntiHero> allAntiHeroes;
    private Map<String, Arena> arenas;
    private Map<String, SuperPower> allAvailablePowers;

    public WarManager(Map<String, ComicCharacter> allHeroes, Map<String, ComicCharacter> allAntiHeroes) {
        this.allHeroes = new HashMap<>();
        this.allAntiHeroes = new HashMap<>();
    }

    public WarManager() {
        this.allCharacters = new LinkedHashMap<>();
        this.allHeroes = new LinkedHashMap<>();
        this.allAntiHeroes = new LinkedHashMap<>();
        this.arenas = new LinkedHashMap<>();
        this.allAvailablePowers = new LinkedHashMap<>();
    }

    @Override
    public String checkComicCharacter(String characterName) {

        String result = "";
        //allCharacters.putAll(allHeroes);
        //allCharacters.putAll(allAntiHeroes);
        if(!allCharacters.containsKey(characterName)) {
            result = String.format("Sorry, fans! %s doesn't exist in our comics!", characterName);
        } else {
            if (allCharacters.get(characterName).getHealth() <= 0) {
                result = String.format("%s has fallen in battle!", characterName);
            }
        }
        return result;
    }

    @Override
    public String addHero(String name, String type, int energy, double health, double intelligence, double heroism) {
        Hero hero;
        switch (type) {
            case "MarvelHero":
                hero = new MarvelHero(name, energy, health, intelligence, heroism);
                break;
            case "DCHero":
                hero = new DCHero(name, energy, health, intelligence, heroism);
                break;
            default: hero = null;
        }

        if(allHeroes.get(hero.getName()) == hero) {
            allHeroes.get(hero.getName()).boostCharacter(hero.getEnergy(), hero.getHealth(), hero.getIntelligence());
            return String.format("%s evolved!", hero.getName());
        } else {
            allHeroes.put(hero.getName(), hero);
            allCharacters.put(hero.getName(), hero);
            return String.format("%s is ready for battle!", hero.getName());
        }
    }

    @Override
    public String addAntiHero(String name, String type, int energy, double health, double intelligence, double evilness) {
        AntiHero antiHero;
        switch (type) {
            case "Titan":
                antiHero = new Titan(name, energy, health, intelligence, evilness);
                break;
            case "Villain":
                antiHero = new Villain(name, energy, health, intelligence, evilness);
                break;
            default: antiHero = null;
        }
        if(allAntiHeroes.get(antiHero.getName()) == antiHero) {
            allAntiHeroes.get(antiHero.getName()).boostCharacter(antiHero.getEnergy(), antiHero.getHealth(), antiHero.getIntelligence());
            return String.format("%s is getting stronger!", antiHero.getName());
        } else {
            allAntiHeroes.put(antiHero.getName(), antiHero);
            allCharacters.put(antiHero.getName(), antiHero);
            return String.format("%s is ready for destruction!", antiHero.getName());
        }
    }

    @Override
    public String addArena(String name, int capacity) {
        Arena arena = null;
        if(this.arenas.containsKey(arena)) {
            return "A battle is about to start there!";
        } else {
            arenas.put(name, new ArenaImpl(name, capacity));
            return String.format("%s is becoming a fighting ground!", name);
        }
    }

    @Override
    public String addHeroToArena(String arenaName, String heroName) {
        if(allHeroes.get(heroName).isCurrentlyOnArena()) {
            return String.format("%s is fighting!", heroName);
        } else if(allHeroes.get(heroName).getHealth() <= 0) {
            return String.format("%s is dead!", heroName);
        } else if(arenas.get(arenaName).isArenaFull()) {
            return "Arena is full!";
        } else {
            arenas.get(arenaName).addHero(allHeroes.get(heroName));
            return String.format("%s is fighting for your freedom in %s!", heroName, arenaName);
        }
    }

    @Override
    public String addAntiHeroToArena(String arenaName,String antiHeroName) {
        if(allHeroes.get(antiHeroName).isCurrentlyOnArena()) {
            return String.format("%s is fighting!", antiHeroName);
        } else if(allAntiHeroes.get(antiHeroName).getHealth() <= 0) {
            return String.format("%s is dead!", antiHeroName);
        } else if(arenas.get(arenaName).isArenaFull()) {
            return "Arena is full!";
        } else {
            arenas.get(arenaName).addAntiHero(allAntiHeroes.get(antiHeroName));
            return String.format("%s and his colleagues are trying to take over %s!", antiHeroName, arenaName);
        }
    }

    @Override
    public String loadSuperPowerToPool(String superPowerName, int superPowerPoints) {
        if(allAvailablePowers.containsKey(superPowerName)) {
            return "This super power already exists!";
        } else {
            allAvailablePowers.put(superPowerName, new Power(superPowerName, superPowerPoints));
            return String.format("%s added to pool!", superPowerName);
        }
    }

    @Override
    public String assignSuperPowerToComicCharacter(String comicCharacterName, String superPowerName) {
        if(!allAvailablePowers.containsKey(superPowerName)) {
            return String.format("%s already assigned!", superPowerName);
        } else {
            //allCharacters.values()
            //        .stream()
            //        .filter(hero -> hero.getName().equals(comicCharacter))
            //        .forEach(hero -> hero.addSuperPower(allAvailablePowers.get(superPower)));
            for (ComicCharacter character : allCharacters.values()) {
                if(character.getName().equals(comicCharacterName)) {
                    character.addSuperPower(allAvailablePowers.get(superPowerName));
                    break;
                }
            }
            allAvailablePowers.remove(superPowerName);
            return String.format("%s has a new super power!", comicCharacterName);
        }
    }

    @Override
    public String usePowers(String characterName) {
        if(allCharacters.get(characterName).getPowers().size() == 0) {
            return String.format("%s has no super powers!", characterName);
        } else {
            allCharacters.get(characterName).useSuperPowers();
            return String.format("%s used his super powers!", characterName);
        }
        //return allCharacters.get(characterName).useSuperPowers();
    }

    @Override
    public String startBattle(String arenaName) {
        return null;
    }

    @Override
    public String endWar() {
        return null;
    }
}
