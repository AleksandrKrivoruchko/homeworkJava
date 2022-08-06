package seminar1;

public class Main {
    public static void main(String[] args) {
        Point2D dot1 = new Point2D();
        Point2D dot2 = new Point2D(0, 2);
        Shape circle = new Circle(dot1, dot2, "red");
        System.out.println(circle);
    }
}
