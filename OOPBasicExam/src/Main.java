import contracts.ComicCharacter;
import engines.WarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        WarManager warManager = new WarManager();

        String line = reader.readLine();
        while (true) {
            if ("WAR_IS_OVER".equals(line)) {
                break;
            }
            String[] lineSplitted = line.split("\\s+");

            String command = lineSplitted[0];
            String name = lineSplitted[1];
            String argument1 = "";
            int energy = 0;
            double health = 0;
            double intelligence = 0;
            double argument2 = 0;

            if(lineSplitted.length > 2) {
                argument1 = lineSplitted[2];
            }
            if(lineSplitted.length > 3) {
                energy = Integer.parseInt(lineSplitted[3]);
                health = Double.parseDouble(lineSplitted[4]);
                intelligence = Double.parseDouble(lineSplitted[5]);
                argument2 = Double.parseDouble(lineSplitted[6]);
            }

            switch (command) {
                case "CHECK_CHARACTER":
                    warManager.checkComicCharacter(name);
                    break;
                case "REGISTER_HERO":
                    warManager.addHero(name, argument1, energy, health, intelligence, argument2);
                    break;
                case "REGISTER_ANTI_HERO":
                    warManager.addAntiHero(name, argument1, energy, health, intelligence, argument2);
                    break;
                case "BUILD_ARENA":
                    warManager.addArena(name, Integer.parseInt(argument1));
                    break;
                case "SEND_HERO":
                    warManager.addHeroToArena(name, argument1);
                    break;
                case "SEND_ANTI_HERO":
                    warManager.addAntiHeroToArena(name, argument1);
                    break;
                case "SUPER_POWER":
                    warManager.loadSuperPowerToPool(name, Integer.parseInt(argument1));
                    break;
                case "ASSIGN_POWER":
                    warManager.assignSuperPowerToComicCharacter(name, argument1);
                    break;
                case "UNLEASH":
                    warManager.usePowers(name);
                    break;
                case "COMICS_WAR":
                    warManager.startBattle(name);
                    break;
            }

            line = reader.readLine();
        }
    }
}
