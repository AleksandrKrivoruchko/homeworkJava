package seminar1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Point dot1 = new Point();
        Point dot2 = new Point(4);
        Point dot3 = new Point(4, 2);
        Shape circle = new Circle(4, Color.GREEN);
        Circle circle1 = new Circle(5, Color.BLUE);
        Shape square = new Square(4, Color.RED);
        Square square1 = new Square(9, Color.WHITE);
        Shape triangle = new Triangle(dot1, dot2, dot3, Color.BLUE);
        Point dot11 = new Point(10, 15);
        Point dot12 = new Point(10, 0);
        Triangle triangle1 = new Triangle(dot11, dot12, dot1, Color.BLACK);

        List<Shape> list = new ArrayList<>();
        list.addAll(List.of(circle1, circle, square, square1, triangle, triangle1));

        System.out.printf("Фигура с максимальной площадью:\n%s\n", maxAreaShape(list));
        System.out.printf("Максимальная площадь %.2f\n", maxArea(list));

        System.out.println("------------------------------------------");
        System.out.println("Коллекция фигур до сортировки:");
        for (var ls : list) {
            System.out.println(ls);
        }

        Collections.sort(list);
        System.out.println("------------------------------------------");
        System.out.println("Коллекция фигур после сортировки:");
        for (var ls : list) {
            System.out.println(ls);
        }
    }

    static Shape maxAreaShape(List<Shape> ls) {
        return Collections.max(ls);
    }

    static double maxArea(List<Shape> ls) {
        return ls.stream().map(p -> p.area())
                .max(Double::compareTo)
                .orElse(.0);
    }
}
