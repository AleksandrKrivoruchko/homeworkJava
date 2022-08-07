package seminar1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point dot1 = new Point();
        Point dot2 = new Point(2);
        Point dot3 = new Point(4, 0);
        Shape circle = new Circle(dot1, 4, Color.GREEN);
        Shape c = new Circle(dot1, 5, Color.BLUE);
        Shape square = new Square(new Point(), 4, Color.RED);
        Shape triangle = new Triangle(dot1, dot2, dot3, Color.BLUE);

        List<Shape> list = new ArrayList<>();
        list.addAll(List.of(c, circle, square, triangle));

        for (var ls : list) {
            System.out.println(ls);
        }
        Collections.sort(list);
        System.out.println("------------------------------------------");
        for (var ls : list) {
            System.out.println(ls);
        }
        System.out.println("------------------------------------------");
        System.out.println(maxArea(list));
    }

    static Shape maxArea(List<Shape> ls) {
        return Collections.max(ls);
    }
}
