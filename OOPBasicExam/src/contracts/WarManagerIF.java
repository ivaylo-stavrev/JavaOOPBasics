package contracts;

public interface WarManagerIF {

    String checkComicCharacter(String characterName);

    String addHero(String name, String type, int energy, double health, double intelligence, double heroism);

    String addAntiHero(String name, String type, int energy, double health, double evilness, double heroism);

    String addArena(String name, int capacity);

    String addHeroToArena(String arenaName,String heroName);

    String addAntiHeroToArena(String arenaName,String antiHeroName);

    String loadSuperPowerToPool(String superPowerName, int superPowerPoints);

    String assignSuperPowerToComicCharacter(String comicCharacterName, String superPowerName);

    String usePowers(String characterName);

    String startBattle(String arenaName);

    String endWar();
}
