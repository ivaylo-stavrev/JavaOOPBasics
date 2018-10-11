package interfaces;

import models.areas.Guild;

public interface ProvinceIf {
    String addGuild(Guild guild);

    String removeGuild(Guild guild);

    Guild getGuildByName(String guildName);

    boolean contains(String guildName);

    String getName();
}
