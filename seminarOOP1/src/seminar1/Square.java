package seminar1;

public class Square extends Shape{
    private Point dot;
    private double len;


    public Square(Point dot, double len, Color c) {
        color = c;
        this.dot = dot;
        this.len = len;
    }

    @Override
    public double area() {
        return len * len;
    }

    @Override
    public String toString() {
        return String.format("Квадрат со стороной %.2f цвет %s площадь %.2f",
                len, color, area());
    }
}
