package ex03_mankind;

public class Worker extends Human {
    private double weekSalary;
    private double hoursPerDay;

    public Worker() { }

    public Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
        setFirstName(firstName);
        setLastName(lastName);
        setWeekSalary(weekSalary);
        setHoursPerDay(hoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if ( !lastName.matches("[A-Z][\\w\\d]+") ) {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if( lastName.length() < 4 ) {
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }

    protected void setWeekSalary(double weekSalary) {
        if(weekSalary < 11) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    protected void setHoursPerDay(double hoursPerDay) {
        if((hoursPerDay < 1) || (hoursPerDay > 12)) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.hoursPerDay = hoursPerDay;
    }

    protected double getWeekSalary() {
        return this.weekSalary;
    }

    protected double getHoursPerDay() {
        return this.hoursPerDay;
    }

    private double calcSalaryPerHour() {
        return getWeekSalary() / 7 * getHoursPerDay();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("Week Salary: ").append(String.format("%.2f", getWeekSalary()))
                .append(System.lineSeparator())
                .append("Hours per day: ").append(String.format("%.2f", getHoursPerDay()))
                .append(System.lineSeparator())
                .append("Salary per hour: ").append(String.format("%.2f", calcSalaryPerHour()));
        return sb.toString();
    }
}
