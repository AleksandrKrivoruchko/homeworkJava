package seminar1;

public abstract class Shape {
    private String color;

    public Shape(String color) {
        this.color = color;
    }

    public Shape() {
        this("black");
    }

    public String getColor() {
        return this.color;
    }

    public double distanceBetweenPoints(Point2D dot1, Point2D dot2) {
        return Math.sqrt(Math.pow(dot1.getX() - dot2.getX(), 2)
                + Math.pow(dot1.getY() - dot2.getY(), 2));
    }

    public abstract double area();
}
