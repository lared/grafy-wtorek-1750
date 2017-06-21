package edu.agh.gg;

public class Coordinates {

    private static final Coordinates START = new Coordinates(0.0, 0.0);

    private final double x;
    private final double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private Coordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates start() {
        return START;
    }

    public static Coordinates of(double x, double y) {
        return new Coordinates(x, y);
    }

    public Coordinates shifted(Coordinates dv) {
        return new Coordinates(x + dv.x, y + dv.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates coordinates = (Coordinates) o;

        if (Double.compare(coordinates.x, x) != 0) return false;
        return Double.compare(coordinates.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
