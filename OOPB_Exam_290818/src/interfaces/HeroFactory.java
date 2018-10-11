package interfaces;

public interface HeroFactory {
    //{guildName} {heroType} {heroName} {health} {fatigue} {magicka}
    Hero create(String heroType, String name, int magicka, int fatigue, int health);
}
