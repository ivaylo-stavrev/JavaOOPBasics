package ex01_person;

public class Person {
    private String name;
    private int age;
    private String address;

    public Person(){ }

    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public Person(String name, int age, String address) {
        this(name, age);
        setAddress(address);
    }

    protected void setName(String name) {
        if(name.length() < 3) {
            throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
        }
        this.name = name;
    }

    protected void setAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("Age must be positive!");
        }
        this.age = age;
    }

    protected void setAddress(String address) {
        this.address = address;
    }

    protected String getName() {
        return this.name;
    }

    protected String getAddress() {
        return this.address;
    }

    protected int getAge() {
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d", this.getName(), this.getAge());
    }
}
