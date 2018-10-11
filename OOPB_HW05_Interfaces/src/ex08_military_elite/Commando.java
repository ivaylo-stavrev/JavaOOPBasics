package ex08_military_elite;

import java.util.Set;

public class Commando extends SpecialisedSoldier implements ICommando {
    private Set<Mission> missions;

    public Commando(String firstName, String lastName, String id, double salary, String corps, Set<Mission> missions) {
        super(firstName, lastName, id, salary, corps);
        this.setMissions(missions);
    }

    @Override
    public Set<Mission> getMissions() {
        return this.missions;
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
        .append("Missions:");
            missions.forEach(m -> {
                sb.append(System.lineSeparator())
                        .append(String.format("  Code Name: %s State: %s", m.getCodeName(), m.getState()));
            });
        return sb.toString();
    }
}
