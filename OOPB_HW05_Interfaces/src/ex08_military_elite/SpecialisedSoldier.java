package ex08_military_elite;

public abstract class SpecialisedSoldier extends Private implements ISpecialisedSoldier {
    private String corps; //Airforces or Marines

    public SpecialisedSoldier(String firstName, String lastName, String id, double salary, String corps) {
        super(firstName, lastName, id, salary);
        this.setCorps(corps);
    }

    public void setCorps(String corps) {
        if(("Airforces".equals(corps)) || ("Marines".equals(corps))) {
            this.corps = corps;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getCorps() {
        return this.corps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(this.getCorps())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
