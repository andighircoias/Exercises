package ro.siit.java.shapes;

import java.util.Objects;

public class Circle extends Shape {
    private float radius;
    private static float PI = 3.14f;


    public Circle(float radius) {
        this.radius = radius;
    }


    public float getPerimeter() {
        //I used Math.abs in case there is a negative value
        return Math.abs(2 * PI * radius);
    }

    public float getSurface() {
        return Math.abs(PI * radius * radius);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Float.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
