package ex03_ferrari;

public class Ferrari implements Pushable, Stoppable{
    public static final String model = "488-Spider";

    private String driver;

    public Ferrari(String driver) {
        this.setDriver(driver);
    }

    public String getModel() {
        return this.model;
    }

    public String getDriver() {
        return this.driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public void pushTheGasPedal() {
        System.out.printf("Zadu6avam sA!");
    }

    @Override
    public void breaks() {
        System.out.printf("Brakes!");
    }
}
