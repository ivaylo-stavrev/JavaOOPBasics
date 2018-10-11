package lab03_shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    protected void setRadius(double radius) {
        this.radius = radius;
    }

    public final double getRadius() {
        return this.radius;
    }

    @Override
    protected void calculatePerimeter() {
        this.setPerimeter(2 * Math.PI * this.getRadius());
    }

    @Override
    protected void calculateArea() {
        this.setArea(Math.PI * radius * radius);
    }
}
