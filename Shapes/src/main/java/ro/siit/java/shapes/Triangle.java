package ro.siit.java.shapes;

import java.util.Objects;

public class Triangle extends Shape {
    private float height;
    private float base;
    private float side1;
    private float side2;

    public Triangle(float height, float base, float side1, float side2) {
        this.height = height;
        this.base = base;
        this.side1 = side1;
        this.side2 = side2;
    }

    public float getPerimeter() {
        //I used Math.abs in case there is a negative value
        return Math.abs(base) + Math.abs(side1) + Math.abs(side2);
    }

    public float getSurface() {
        return Math.abs((base * height) / 2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Float.compare(triangle.height, height) == 0 &&
                Float.compare(triangle.base, base) == 0 &&
                Float.compare(triangle.side1, side1) == 0 &&
                Float.compare(triangle.side2, side2) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), height, base, side1, side2);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "height=" + height +
                ", base=" + base +
                ", side1=" + side1 +
                ", side2=" + side2 +
                '}';
    }
}
