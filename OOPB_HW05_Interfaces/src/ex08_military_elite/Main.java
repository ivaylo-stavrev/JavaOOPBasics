package ex08_military_elite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Soldier> soldiers = new LinkedList<>();
        Map<String, Private> onlyPrivates = new HashMap<>();
        Set<Private> privatesOfLeutanent;
        Set<Repair> repairs;
        Set<Mission> missions;

        String line = reader.readLine();
        while (true) {
            if ("End".equals(line)) {
                break;
            }
            String[] lineSplitted = line.split("\\s+");

            String soldierType = lineSplitted[0];
            String id = lineSplitted[1];
            String firstName = lineSplitted[2];
            String lastName = lineSplitted[3];
            String codeName = "";
            double salary = 0;

            if("Spy".equals(soldierType)) {
                codeName = lineSplitted[4];
            } else {
                salary = Double.parseDouble(lineSplitted[4]);
            }
            String corps;

            try {
                switch (soldierType) {
                    case "Private":
                        Private currentPrivate = new Private(firstName, lastName, id, salary);
                        onlyPrivates.put(id, currentPrivate);
                        soldiers.add(currentPrivate);
                        break;
                    case "LeutenantGeneral":
                        privatesOfLeutanent = new LinkedHashSet<>();
                        for (int i = 5; i < lineSplitted.length; i++) {
                            if (onlyPrivates.containsKey(lineSplitted[i])) {
                                privatesOfLeutanent.add(onlyPrivates.get(lineSplitted[i]));
                            }
                        }
                        LeutenantGeneral currentLeutenantGeneral = new LeutenantGeneral(firstName, lastName, id, salary, privatesOfLeutanent);
                        soldiers.add(currentLeutenantGeneral);
                        break;
                    case "Engineer":
                        repairs = new LinkedHashSet<>();
                        corps = lineSplitted[5];
                        for (int i = 6; i < lineSplitted.length; i += 2) {
                            String part = lineSplitted[i];
                            int hoursForRepair = Integer.parseInt(lineSplitted[i + 1]);
                            repairs.add(new Repair(part, hoursForRepair));
                        }
                        Engineer currentEngineer = new Engineer(firstName, lastName, id, salary, corps, repairs);
                        soldiers.add(currentEngineer);
                        break;
                    case "Commando":
                        missions = new LinkedHashSet<>();
                        corps = lineSplitted[5];
                        for (int i = 6; i < lineSplitted.length; i += 2) {
                            String missionName = lineSplitted[i];
                            String missionState = lineSplitted[i + 1];
                            try {
                                missions.add(new Mission(missionName, missionState));
                            } catch (IllegalArgumentException iae) {
                                // just skip the mission with wrong state.
                            }
                        }
                        Commando currentCommando = new Commando(firstName, lastName, id, salary, corps, missions);
                        soldiers.add(currentCommando);
                        break;
                    case "Spy":
                        Spy currentSpy = new Spy(firstName, lastName, id, codeName);
                        soldiers.add(currentSpy);
                        break;
                }
            } catch (IllegalArgumentException iae) {
                // Skip the whole line in case of wrong corps name.
            }
            line = reader.readLine();
        }
        for (Soldier soldier : soldiers) {
            System.out.println(soldier.toString());
        }
    }
}
