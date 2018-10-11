package ex07_food_shortage;

public class Citizen implements Indexable, Bornable, Buyer {
    private String name;
    private String age;
    private String id;
    private String birthday;
    private int food;

    public Citizen(String name, String age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
        this.food = DEFAULT_FOOD;
    }

    public void setFood(int food) {
        this.food = food;
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

    @Override
    public void buyFood() {
        this.setFood(this.getFood() + 10);
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
