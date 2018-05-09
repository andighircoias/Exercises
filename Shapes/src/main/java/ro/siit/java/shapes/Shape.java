package ro.siit.java.shapes;
import java.util.*;

public class Shape {
    private Set<Shape> shapeHashSet = new HashSet<>();


    public Set<Shape> getShapeHashSet() {
        return shapeHashSet;
    }

    public float getPerimeter() {

        return 0;
    }

    public float getSurface() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return Objects.equals(shapeHashSet, shape.shapeHashSet);
    }

    @Override
    public int hashCode() {

        return Objects.hash(shapeHashSet);
    }

    public void addShapesToList(Shape s) {
        if (!shapeHashSet.add(s)) {
            System.out.println("This shape already exists!");
        }
    }

    public float calculateSumOfPerimeters() {
        float sumOfPerimeter = 0.0f;
        for (Shape shape : shapeHashSet) {
            sumOfPerimeter = sumOfPerimeter + shape.getPerimeter();
        }
        return sumOfPerimeter;
    }

    public float calculateSumOfSurfaces() {
        float sumOfSurface = 0.0f;
        for (Shape shape : shapeHashSet) {
            sumOfSurface = sumOfSurface + shape.getSurface();
        }
        return sumOfSurface;

    }


    @Override
    public String toString() {
        return "Shape{" +
                "shapeHashSet=" + shapeHashSet +
                '}';
    }
}

