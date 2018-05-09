import org.junit.Test;
import ro.siit.java.shapes.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class Testing {

    @Test
    public void CheckIfPerimeterAndSurfaceWorkFine() {
        Square square = new Square(4.0f);
        Triangle triangle = new Triangle(-5.0f, 7.0f, -4.0f, 4.0f);
        Circle circle = new Circle(4.5f);
        Rect rect = new Rect(-4.5f, 5.0f);

        float squarePerimeter = square.getPerimeter();
        float squareSurface = square.getSurface();
        float rectanglePerimeter = rect.getPerimeter();
        float rectangleSurface = rect.getSurface();
        float trianglePerimeter = triangle.getPerimeter();
        float triangleSurface = triangle.getSurface();
        float circlePerimeter = circle.getPerimeter();
        float circleSurface = circle.getSurface();
        //assertions
        //for perimeter
        assertEquals(16.0f, squarePerimeter, 0.0f);
        assertEquals(15.0f, trianglePerimeter, 0.0f);
        assertEquals(28.26f, circlePerimeter, 0.0f);
        assertEquals(19.0f, rectanglePerimeter, 0.0f);
        //surface
        assertEquals(16.0f, squareSurface, 0.0f);
        assertEquals(17.5f, triangleSurface, 0.0f);
        assertEquals(63.585f, circleSurface, 0.0f);
        assertEquals(22.5f, rectangleSurface, 0.0f);
    }

    @Test
    public void AddShapesToCollections() {
        HashSet<Shape> hashSet = new HashSet<Shape>();

        Shape square = new Square(5.0f);
        Shape rectangle = new Rect(8.0f, 4.0f);
        Shape triangle = new Triangle(5.0f, 6.0f, 3.0f, 2.0f);
        Shape circle = new Circle(8.0f);

        hashSet.add(square);
        hashSet.add(rectangle);
        hashSet.add(triangle);
        hashSet.add(circle);
        //check if they all got added
        assertEquals(4, hashSet.size());
    }

    @Test
    public void dontAllowSimilarShapesInTheCollection() {
        Set<Shape> multiple = new HashSet<Shape>();
        Shape square = new Square(5.0f);
        Shape rectangle = new Rect(8.0f, 4.0f);
        Shape triangle = new Triangle(5.0f, 6.0f, 3.0f, 2.0f);
        Shape circle = new Circle(8.0f);

        multiple.add(square);
        multiple.add(rectangle);
        multiple.add(triangle);
        multiple.add(circle);
        //The size should be 4
        assertEquals(4, multiple.size());

        //I will add the exact same triangle
        Shape triangle2 = new Triangle(5.0f, 6.0f, 3.0f, 2.0f);
        multiple.add(triangle2);
        //The size shoul still be 4
        assertEquals(4, multiple.size());
        //I will add a unique object
        Shape rectangle2 = new Rect(3.2f, 9.9f);
        multiple.add(rectangle2);
        //The size should be 5 now
        assertEquals(5, multiple.size());
    }
    @Test
    public void calculateTheSumOfAllPerimetersAndSurfacesOfShapes(){

        Set<Shape> set = new HashSet<Shape>();
        Shape square = new Square(5.0f);
        Shape rectangle = new Rect(8.0f, 4.0f);
        Shape triangle = new Triangle(5.0f, 6.0f, 3.0f, 2.0f);
        Shape circle = new Circle(8.0f);
        set.add(square);
        set.add(rectangle);
        set.add(triangle);
        set.add(circle);
        float perimeterSum=0;
        float surfaceSum=0;
        for (Shape shape : set){
            perimeterSum+=shape.getPerimeter();
        }

       assertEquals(105.240005f, perimeterSum, 0.0f);
        for (Shape shape : set){
            surfaceSum+=shape.getSurface();
        }
        assertEquals(272.96002f, surfaceSum, 0.0f);

    }
}
