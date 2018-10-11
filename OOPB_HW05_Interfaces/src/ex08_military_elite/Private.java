package ex08_military_elite;

public class Private extends Soldier implements IPrivate {
    private double salary;

    public Private(String firstName, String lastName, String id, double salary) {
        super(firstName, lastName, id);
        this.setSalary(salary);
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(String.format(" Salary: %.2f", salary));

        return sb.toString();
    }
}
