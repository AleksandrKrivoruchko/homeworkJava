package seminar1;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int value) {
        this(value, value);
    }

    public Point() {
        this(0);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distance(Point dot) {
        return Math.sqrt(Math.pow(x - dot.getX(), 2)
                + Math.pow(y - dot.getY(), 2));
    }
    @Override
    public String toString() {
        return String.format("(%d, %d)", x, y);
    }
}
