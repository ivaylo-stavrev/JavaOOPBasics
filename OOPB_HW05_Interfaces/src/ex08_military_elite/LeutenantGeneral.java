package ex08_military_elite;

import java.util.Set;

public class LeutenantGeneral extends Private implements ILeutenantGeneral{
    private Set<Private> privates;

    public LeutenantGeneral(String firstName, String lastName, String id, double salary, Set<Private> privates) {
        super(firstName, lastName, id, salary);
        this.privates = privates;
    }

    @Override
    public Set<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Privates:");
                //.append(System.lineSeparator());
        //this.getPrivates().stream()
        this.privates.stream()
                .sorted((e1, e2) -> Integer.compare(Integer.parseInt(e2.getId()), Integer.parseInt(e1.getId())))
                .forEach(p -> {
                    sb.append(System.lineSeparator())
                            .append("  ")
                            .append(p.toString());
                });
        return sb.toString();
    }
}
