package ex08_military_elite;

public abstract class Soldier implements ISoldier {
    private String firstName;
    private String lastName;
    private String id;

    public Soldier(String firstName, String lastName, String id) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s", this.getFirstName(), this.getLastName(), this.getId()));
        return sb.toString();
    }
}
