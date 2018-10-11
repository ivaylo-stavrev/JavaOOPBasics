package lab03_shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    public double getArea() {
        return this.area;
    }

    protected abstract void calculatePerimeter();

    protected abstract void calculateArea();
}
