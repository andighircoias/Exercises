import java.util.Scanner;

/**
 * Display the max digit from a number.
 */
public class MaxDigit {


    public static void digit() {
        System.out.println("\n3. Display the max digit from a number.");
        int a, digit, largest = 0;
        System.out.println("Enter a random number:  ");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();

        while (a > 0) {
            digit = a % 10;

            if (largest < digit) {
                largest = digit;

            }
            a = a / 10;
        }

        System.out.println(" Max digit is: " + largest);
    }
}
