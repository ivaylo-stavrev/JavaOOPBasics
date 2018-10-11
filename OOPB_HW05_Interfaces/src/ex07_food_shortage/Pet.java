package ex07_food_shortage;

public class Pet implements Bornable {
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
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
}
