package ex03_mankind;

public class Human {
    private String firstName;
    protected String lastName;

    public Human() { }

    public Human(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }

    protected void setFirstName(String firstName) {
        if ( !firstName.matches("[A-Z][\\w\\d]+") ) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if( firstName.length() < 4 ) {
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    protected void setLastName(String lastName) {
        if( !lastName.matches("[A-Z][\\w\\d]+") ) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if( lastName.length() < 3 ) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    protected String getFirstName() {
        return this.firstName;
    }

    protected String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("First Name: ").append(this.getFirstName())
                .append(System.lineSeparator())
                .append("Last Name: ").append(getLastName())
                .append(System.lineSeparator());
        return sb.toString();
    }
}
