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
        double ab = a.distance(b);
        double ac = a.distance(c);
        double bc = b.distance(c);
        double hM = (ab + ac + bc) / 2;
        return Math.sqrt(hM * (hM - ab) * (hM - ac) * (hM - bc));
    }

    @Override
    public String toString() {
        return String.format("Треугольник цвет %s площадь %.2f", color, area());
    }
}
