package interfaces;

public interface GuildIf {
    String addHero(Hero hero);

    String removeHero(Hero hero);

    Hero getHeroByName(String heroName);

	Long getGuildSize();

    double getGuildPower();

    String getGuildSpecialization();
}
