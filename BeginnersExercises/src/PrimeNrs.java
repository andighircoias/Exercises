import java.util.Scanner;

/**
 * Display all the prime numbers lower than a given number.
 */
public class PrimeNrs {

    public static void prime() {
        System.out.println("\n5. Display all the prime numbers lower than a given number.\n");
        int nrprim = 0;
        int divizor = 0;

        String numerePrime = "";
        System.out.println("Enter a random number: ");
        Scanner numar = new Scanner(System.in);
        int n = numar.nextInt();

        if (n != 1) {
            for (nrprim = 1; nrprim < n; nrprim++) {
                int numarDeDivizori = 0;

                for (divizor = nrprim; divizor >= 1; divizor--) {
                    if (nrprim % divizor == 0) {
                        numarDeDivizori = numarDeDivizori + 1;
                    }
                }
                if (numarDeDivizori == 2) {
                    numerePrime = numerePrime + nrprim + " ";
                }
            }
            System.out.println("The prime number lower than " + n + " are :");
            System.out.println("1 " + numerePrime);

        } else {
            System.out.println("There are no prime numbers lower than " + n + " !!!");
        }

    }
}
