package lab02_method_overriding;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA, double sideB) {
        this.setSideA(sideA);
        this.setSideB(sideB);
    }

    public Rectangle(double sideA) {
        this.setSideA(sideA);
    }

    protected void setSideA(double sideA) {
        this.sideA = sideA;
    }

    protected void setSideB(double sideB) {
        this.sideB = sideB;
    }

    protected double getSideA() {
        return this.sideA;
    }

    protected double getSideB() {
        return this.sideB;
    }

    public double area() {
        return this.getSideA() * this.getSideB();
    }
}
