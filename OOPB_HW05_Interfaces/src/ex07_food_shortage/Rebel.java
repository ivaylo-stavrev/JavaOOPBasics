package ex07_food_shortage;

public class Rebel implements Buyer {
    private String name;
    private String age;
    private String group;
    private int food;

    public Rebel(String name, String age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = DEFAULT_FOOD;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(int food) {
        this.food = food;
    }

    @Override
    public void buyFood() {
        this.setFood(this.getFood() + 5);
    }

    @Override
    public int getFood() {
        return this.food;
    }
}
