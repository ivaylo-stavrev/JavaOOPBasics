package ex06_birthday_party;

public class Citizen implements Indexable, Bornable {
    private String name;
    private String age;
    private String id;
    private String birthday;

    public Citizen(String name, String age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthDate() {
        return this.birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
