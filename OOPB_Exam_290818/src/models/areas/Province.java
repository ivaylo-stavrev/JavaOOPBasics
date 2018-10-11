package models.areas;

import interfaces.ProvinceIf;

import java.util.LinkedHashMap;
import java.util.Map;

public class Province implements ProvinceIf {
    private String name;
    private Map<String, Guild> guilds = new LinkedHashMap<>();

    public Province(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String addGuild(Guild guild) {
        if (this.contains(guild.getName())) {
            return String.format("Guild already exists.");
        }
        guilds.put(guild.getName(), guild);
        return String.format("Added Guild: %s", guild.getName());
    }

    @Override
    public String removeGuild(Guild guild) {
        if (!this.contains(guild.getName())) {
            return String.format("Guild %s does not exist.", guild.getName());
        }
        guilds.remove(guild.getName());
        return String.format("Removed guild [%s] with %d members.", guild.getName(), guild.getGuildSize());
    }

    //TODO: Check for null on the upper level where the method is called!
    @Override
    public Guild getGuildByName(String guildName) {
        if (this.contains(guildName)) {
            return guilds.get(guildName);
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(String guildName) {
        if (guilds.containsKey(guildName)) {
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder provinceSB = new StringBuilder();
        provinceSB.append(String.format("Province: %s", this.getName()))
        .append(System.lineSeparator())
        .append("#Guilds: ");

        if (this.guilds.size() == 0) {
            provinceSB.append("None");
        } else {
            for (Guild guild : guilds.values()) {
                provinceSB.append(System.lineSeparator())
                        .append(guild.toString());
            }
        }

        return provinceSB.toString();
    }
}
