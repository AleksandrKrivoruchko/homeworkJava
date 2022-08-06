package seminar1;

public class Square extends Shape{
    private Point2D topLeft;
    private Point2D bottomRight;
    private Point2D topRight;
    private Point2D bottomLeft;

    public Square(Point2D topLeft, Point2D bottomRight,
                  Point2D topRight, Point2D bottomLeft, String color) {
        super(color);
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
    }

    @Override
    public double area() {
        return (topRight.getX() - topLeft.getX()) * (bottomRight.getY() - topRight.getY());
    }
}
