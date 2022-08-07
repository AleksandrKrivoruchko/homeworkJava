package seminar1;

public abstract class Shape implements Comparable<Shape> {
    protected Color color;


    public abstract double area();

    public int compareTo(Shape shape) {
        return Double.compare(this.area(), shape.area());
    }

}
