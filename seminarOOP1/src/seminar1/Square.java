package seminar1;

public class Square extends Shape{

    private double len;


    public Square(double len, Color c) {
        color = c;
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
