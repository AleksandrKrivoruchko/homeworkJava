package seminar1;

public class Circle extends Shape{
    private Point2D dot1;
    private Point2D dot2;
    private double radius;

    public Circle(Point2D dot1, Point2D dot2, String color) {
        super(color);
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.radius = distanceBetweenPoints(this.dot1, this.dot2);
    }

    public Circle(Point2D dot1, Point2D dot2) {
        this(dot1, dot2, "");
    }

    public double getRadius() {
        return this.radius;
    }

    @Override
    public String toString() {
        return String.format("Круг %s радиусом %.2f\n %s %s",
                super.getColor(), this.radius, dot1, dot2);
    }
    @Override
    public double area() {
        return Math.PI * Math.pow(distanceBetweenPoints(this.dot1, this.dot2), 2);
    }
}
