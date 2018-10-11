package lab03_shapes;

public class Rectangle extends Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }

    protected void setHeight(double height) {
        this.height = height;
    }

    protected void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    @Override
    protected void calculatePerimeter() {
        this.setPerimeter(2 * this.height + 2 * this.width);
    }

    @Override
    protected void calculateArea() {
        this.setArea(this.height * this.width);
    }
}
