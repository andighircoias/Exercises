package ro.siit.java.shapes;

import java.util.Objects;

public class Rect extends Shape {
    private float lenght;
    private float width;


    public Rect(float lenght, float width) {
        this.lenght = lenght;
        this.width = width;
    }

    public float getPerimeter() {
        //I used Math.abs in case there is a negative value
        return (Math.abs(lenght) + Math.abs(width)) * 2;
    }

    public float getSurface() {
        return Math.abs(lenght * width);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rect)) return false;
        if (!super.equals(o)) return false;
        Rect rect = (Rect) o;
        return Float.compare(rect.lenght, lenght) == 0 &&
                Float.compare(rect.width, width) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), lenght, width);
    }

    @Override
    public String toString() {
        return "Rect{" +
                "lenght=" + lenght +
                ", width=" + width +
                '}';
    }
}

