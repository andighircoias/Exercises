import java.util.Scanner;

public class MaxDigit {
    public static void main (String [] args){
		
	findDigit();
   
    }
	
	
	
	public static void findDigit(){
		   int a, digit, largest=0;
        System.out.println("Enter the number: ");
        Scanner sc = new Scanner(System.in);
        a=sc.nextInt();

        while (a>0){
            digit=a%10;

            if (largest<digit){
                largest=digit;

            }
			
            a=a/10;
        }
		
        System.out.println(" Max digit is: " +largest);	
	}
}
