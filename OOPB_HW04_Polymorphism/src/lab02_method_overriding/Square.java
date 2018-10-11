package lab02_method_overriding;

public class Square extends Rectangle {
    public Square (double sideA) {
        super(sideA);
    }

    //protected void setSideA(double sideA) {
    //    this.sideA = sideA;
    //}

    //protected double getSideA() {
    //    return this.sideA;
    //}

    @Override
    public double area() {
        return this.getSideA() * this.getSideA();
    }
}
