package ro.siit.java.shapes;

import java.util.Objects;

public class Square extends Shape {
    private float side;


    public Square(float side) {
        this.side = side;

    }

    public float getPerimeter() {
        //I used Math.abs in case there is a negative value
        return Math.abs(4 * side);
    }

    public float getSurface() {
        return Math.abs(side * side);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Float.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), side);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
