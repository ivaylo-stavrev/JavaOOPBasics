package ex08_military_elite;

import java.util.Set;

public class Engineer extends SpecialisedSoldier implements IEngineer{
    //private Map<String, Integer> repairs;
    private Set<Repair> repairs;

    public Engineer(String firstName, String lastName, String id, double salary, String corps, Set<Repair> repairs) {
        super(firstName, lastName, id, salary, corps);
        this.setRepairs(repairs);
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public Set<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("Repairs:");
        repairs.forEach(r -> {
            sb.append(System.lineSeparator())
                    .append(String.format("  Part Name: %s Hours Worked: %s", r.getPartName(), r.getHoursWorked()));
        });
        return sb.toString();
    }
}
