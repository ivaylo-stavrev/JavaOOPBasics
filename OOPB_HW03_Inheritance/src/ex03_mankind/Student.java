package ex03_mankind;

public class Student extends Human {
    private int facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        setFacultyNumber(facultyNumber);
    }

    protected void setFacultyNumber(String facultyNumber) {
        if((facultyNumber.length() < 5) || (facultyNumber.length() > 10)) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = Integer.parseInt(facultyNumber);
    }

    protected int getFacultyNumber() {
        return this.facultyNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("Faculty number: ").append(getFacultyNumber());
        return sb.toString();
    }
}
