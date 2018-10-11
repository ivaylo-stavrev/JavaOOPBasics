package ex08_military_elite;

public class Spy extends Soldier implements ISpy {
    private String codeNumber;

    public Spy(String firstName, String lastName, String id, String codeNumber) {
        super(firstName, lastName, id);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append(String.format("Code Number: %s", this.getCodeNumber()));
        return sb.toString();
    }
}
