package engines;

import factories.HeroFactoryImpl;
import interfaces.Hero;
import interfaces.HeroFactory;
import interfaces.ProvinceIf;
import io.implementations.ConsoleReader;
import io.implementations.ConsoleWriter;
import io.io_interfaces.Reader;
import io.io_interfaces.Writer;
import models.areas.Guild;
import models.areas.Province;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Engine implements Runnable {
    private Reader reader = new ConsoleReader();
    private Writer writer = new ConsoleWriter();
    private HeroFactory heroFactory = new HeroFactoryImpl();
    private Map<String, Province> provinces = new TreeMap<>();
    private ProvinceIf selectedProvince = null;


    @Override
    public void run() {
        String guildName;
        String line = reader.readLine();
        while (true) {
//            if ("END".equals(line)) {
//                break;
//            }
            String[] lineSplitted = line.split(":\\s+");

            String cmd = lineSplitted[0];
            String[] args = Arrays.stream(line.split("\\s+")).skip(1).toArray(String[]::new);
            Guild currentGuild;

            switch (cmd) {
                case "CREATE_PROVINCE":
                    String provinceName = args[0];
                    if (provinces.containsKey(provinceName)) {
                        writer.writeLine(String.format("Province with name %s already exists!", provinceName));
                        writer.writeLine("---");
                        break;
                    }
                    provinces.put(provinceName, new Province(provinceName));
                    writer.writeLine(String.format("Created province %s", provinceName));
                    writer.writeLine("---");
                    selectedProvince = provinces.get(provinceName);
                    break;
                case "SELECT":
                    String provinceNameToSelect = args[0];
                    if (!provinces.containsKey(provinceNameToSelect)) {
                        writer.writeLine(String.format("Province %s does not exist", provinceNameToSelect));
                        writer.writeLine("---");
                        break;
                    } else if (provinceNameToSelect.equals(selectedProvince.getName())) {
                        writer.writeLine(String.format("Province %s has already been selected!", provinceNameToSelect));
                        writer.writeLine("---");
                        break;
                    } else {
                        selectedProvince = provinces.get(provinceNameToSelect);
                        writer.writeLine(String.format("Province %s selected!", provinceNameToSelect));
                        writer.writeLine("---");
                        break;
                    }
                case "ADD_HERO":
                    if (!checkForSelectedProvince()) {
                        break;
                    }
                    guildName = args[0];
                    String heroType = args[1];
                    String heroName = args[2];
                    int heroHealth = Integer.parseInt(args[3]);
                    int heroFatigue = Integer.parseInt(args[4]);
                    int heroMagicka = Integer.parseInt(args[5]);
                    Hero hero = this.heroFactory.create(heroType, heroName, heroMagicka, heroFatigue, heroHealth);
                    if (!selectedProvince.contains(guildName)) {
                        addGuild(guildName);
                    }
                    Guild selectedGuild = selectedProvince.getGuildByName(guildName);
                    try {
                        writer.writeLine(selectedGuild.addHero(hero));
                    } catch (IllegalArgumentException iae) {
                        writer.writeLine(iae.getMessage());
                    }
                    writer.writeLine("---");
                    break;
                case "ADD_GUILD":
                    if (!checkForSelectedProvince()) {
                        break;
                    }
                    guildName = args[0];
                    addGuild(guildName);
                    break;
                case "DETAILS":
                    if (!checkForSelectedProvince()) {
                        break;
                    }
                    guildName = args[0];
                    StringBuilder detailsSB = new StringBuilder();
                    currentGuild = selectedProvince.getGuildByName(guildName);
                    if (args.length == 2) {
                        // details hero
                        heroName = args[1];
                        Hero curentHero = currentGuild.getHeroByName(heroName);
                        detailsSB.append(curentHero.toString());
                        writer.writeLine(detailsSB.toString());
                    } else {
                        // details guild
                        if (selectedProvince.contains(guildName)) {
                            detailsSB.append(String.format("Guild: %s", guildName))
                                    .append(System.lineSeparator())
                                    .append("###Heroes: ")
                                    .append(currentGuild.heroesToString());

                        } else {
                            detailsSB.append(String.format("Guild [%s] does not exist.", guildName));
                        }
                        writer.writeLine(detailsSB.toString());
                    }
                    writer.writeLine("---");
                    break;
                case "REMOVE":
                    if (!checkForSelectedProvince()) {
                        break;
                    }
                    guildName = args[0];
                    currentGuild = selectedProvince.getGuildByName(guildName);
                    if (args.length == 2) {
                        // remove hero
                        heroName = args[1];
                        Hero currentHero = currentGuild.getHeroByName(heroName);
                        writer.writeLine(currentGuild.removeHero(currentHero));
                    } else {
                        // remove guild
                        writer.writeLine(selectedProvince.removeGuild(currentGuild));
                    }
                    writer.writeLine("---");
                    break;
                case "FIGHT":
                    if (!checkForSelectedProvince()) {
                        break;
                    }
                    Hero hero1;
                    Hero hero2;
                    Hero startingHero;
                    Hero respondingHero;
                    Guild guild1;
                    Guild guild2;
                    String guild1Name = args[0];
                    String hero1Name = args[1];
                    String guild2Name = args[2];
                    String hero2Name = args[3];

                    if (guild1Name.equals(guild2Name)) {
                        writer.writeLine("Heroes from the same guild can not fight each other.");
                        writer.writeLine("---");
                        break;
                    }
                    guild1 = selectedProvince.getGuildByName(guild1Name);
                    guild2 = selectedProvince.getGuildByName(guild2Name);
                    hero1 = guild1.getHeroByName(hero1Name);
                    hero2 = guild2.getHeroByName(hero2Name);
                    if (hero1 == null || hero2 == null) {
                        writer.writeLine("No such hero in this guild!");
                        writer.writeLine("---");
                        break;
                    }

                    if (hero1.getHealth() == hero2.getHealth()) {
                        if (hero1.getOffense() <= hero2.getOffense()) {
                            //hero1.attack(hero2);
                            startingHero = hero1;
                            respondingHero = hero2;
                        } else {
                            //hero2.attack(hero1);
                            startingHero = hero2;
                            respondingHero = hero1;
                        }
                    } else if (hero1.getHealth() < hero2.getHealth()) {
                        //hero1.attack(hero2);
                        startingHero = hero1;
                        respondingHero = hero2;
                    } else {
                        //hero2.attack(hero1);
                        startingHero = hero2;
                        respondingHero = hero1;
                    }

                    while(true) {
                        startingHero.attack(respondingHero);
                        if (respondingHero.isDead()) {
                            if (guild1.getHeroByName(respondingHero.getName()) != null){
                                guild1.removeHero(respondingHero);
                            } else {
                                guild2.removeHero(respondingHero);
                            }
                            writer.writeLine(String.format("Hero %s sliced hero %s.", startingHero.getName(), respondingHero.getName()));
                            writer.writeLine("---");
                            break;
                        }
                        respondingHero.attack(startingHero);
                        if (startingHero.isDead()) {
                            if (guild1.getHeroByName(startingHero.getName()) != null){
                                guild1.removeHero(startingHero);
                            } else {
                                guild2.removeHero(startingHero);
                            }
                            writer.writeLine(String.format("Hero %s sliced hero %s.", respondingHero.getName(), startingHero.getName()));
                            writer.writeLine("---");
                            break;
                        }
                    }


                case "END": //TODO: Consider if the check for selectedProvince should be applied in this case!
                    if (!checkForSelectedProvince()) {
                        break;
                    }
                    for (Province province : provinces.values()) {
                        writer.writeLine(province.toString());
                    }
                    return;
            }

            line = reader.readLine();
        }
    }

    private void addGuild(String guildName) {
        if (selectedProvince.contains(guildName)) {
            writer.writeLine("Guild already exists.");
            writer.writeLine("---");
            return;
        }
        selectedProvince.addGuild(new Guild(guildName));
        writer.writeLine(String.format("Added Guild: %s", guildName));
        writer.writeLine("---");
    }

    private boolean checkForSelectedProvince() {
        if (this.selectedProvince == null) {
            writer.writeLine("No province selected!");
            return false;
        }
        return true;
    }
}
