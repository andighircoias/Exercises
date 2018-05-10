import java.util.Scanner;

/**
 * Check if a number is palindrom( e.g palindrom 1221, 34143).
 */

public class Palindrom {


    public static void findifPalindrom() {
        System.out.printf("\n4. .Check if a number is palindrom( e.g palindrom 1221, 34143)\n");
        int a, sum = 0, b;
        System.out.println("Enter a random number: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        b = n;
        while (n > 0) {
            a = n % 10;
            sum = (sum * 10) + a;
            n = n / 10;
        }
        if (b == sum) {
            System.out.println("Number is palindrome.");

        } else {
            System.out.println("Number is not palindrome.");
        }
    }
}
