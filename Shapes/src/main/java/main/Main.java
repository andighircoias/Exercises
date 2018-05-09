package main;
import ro.siit.java.shapes.*;

public class Main {
    public static void main(String[] args) {
        Shape theBoss = new Shape();
        Shape square = new Square(5.0f);
        Shape rectangle = new Rect(8.0f, 4.0f);
        Shape triangle = new Triangle(5.0f, 6.0f, 3.0f, 2.0f);
        Shape circle = new Circle(8.0f);
        theBoss.addShapesToList(square);
        theBoss.addShapesToList(rectangle);
        theBoss.addShapesToList(triangle);
        theBoss.addShapesToList(circle);
        System.out.println(theBoss.getShapeHashSet());

        //Adding a new unique shape
        Shape square2 = new Square(4.5f);
        theBoss.addShapesToList(square2);
        System.out.println(theBoss.getShapeHashSet());
        //Adding a same shape
        Shape triangle2 = new Triangle(5.0f, 6.0f, 3.0f, 2.0f);
        theBoss.addShapesToList(triangle2);
        //Calculate the perimeter and surface
        System.out.println("Total sum or per is: "+theBoss.calculateSumOfPerimeters());
        System.out.println("Total sum of perimeter is: "+theBoss.calculateSumOfSurfaces());

        Shape circle2 = new Circle(4.3f);
        theBoss.addShapesToList(circle2);
        System.out.println("Total sum or per is: "+theBoss.calculateSumOfPerimeters());
        System.out.println("Total sum of perimeter is: "+theBoss.calculateSumOfSurfaces());

        System.out.println(theBoss.getShapeHashSet());

    }
}
