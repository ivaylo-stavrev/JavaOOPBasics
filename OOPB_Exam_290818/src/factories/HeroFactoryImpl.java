package factories;

import interfaces.Hero;
import interfaces.HeroFactory;
import models.characters.*;

public class HeroFactoryImpl implements HeroFactory {

    public HeroFactoryImpl() {
    }

    @Override
    public Hero create(String heroType, String name, int magicka, int fatigue, int health) {
        switch (heroType) {
            case "Redguard":
                return new Redguard(name, magicka, fatigue, health);
            case "Khajiit":
                return new Khajiit(name, magicka, fatigue, health);
            case "Orc":
                return new Orc(name, magicka, fatigue, health);
            case "Nord":
                return new Nord(name, magicka, fatigue, health);
            case "Breton":
                return new Breton(name, magicka, fatigue, health);
            case "Dunmer":
                return new Dunmer(name, magicka, fatigue, health);
            default:
                return null;
        }
    }
}
