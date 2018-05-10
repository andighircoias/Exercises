/**
 * Calculate the first n numbers.
 */
public class NumberSum {
    public static void findSum() {
        System.out.printf("1. Calculate the sum of the first 100 numbers higher than 0\n");
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("Sum of the first 100 numbers higher than 1 is: " + sum);
    }

}