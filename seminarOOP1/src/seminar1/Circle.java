package seminar1;

public class Circle extends Shape{
    private double radius;



    public Circle(double radius, Color c) {
        color = c;
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public String toString() {
        return String.format("Круг радиусом %.2f, цвет %s площадь %.2f",
                 radius, color, area());
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}
