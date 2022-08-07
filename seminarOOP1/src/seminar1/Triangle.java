package seminar1;

public class Triangle extends Shape{
    Point a;
    Point b;
    Point c;

    public Triangle(Point a, Point b, Point c, Color cl) {
        color = cl;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double area() {
        return a.distance(b) * a.distance(c) / 2;
    }

    @Override
    public String toString() {
        return String.format("Треугольник с площадью %.2f, цвет %s", area(), color);
    }
}
