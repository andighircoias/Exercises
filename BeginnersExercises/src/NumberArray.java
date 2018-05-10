import java.util.Scanner;

/**
 * Display the smallest number from an array of numbers.
 */
public class NumberArray {


    public static void findNumber() {

        System.out.println("\n2. Display the smallest number from an array of numbers.");
        int a;
        System.out.println("How many numbers do you want to enter? ");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        int vector[] = new int[a];
        int smallest = Integer.MAX_VALUE;
        for (int counter = 0; counter < a; counter++) {
            System.out.println("Enter number " + (counter + 1));
            vector[counter] = scanner.nextInt();

        }

        for (int in : vector) {
            if (in < smallest) {
                smallest = in;
            }
        }
        System.out.println("Smallest number in this array is: : " + smallest);


    }
}
