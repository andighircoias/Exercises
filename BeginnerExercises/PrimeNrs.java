import java.util.Scanner;

public class PrimeNrs {
    public static void main(String[] args) {
		pri();
    }
	
	
	
	public static void pri(){
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


