import java.util.Scanner;

public class NumberArray {
    public static void main(String[] args) {
		
		findNumber();

    }
	
	public static void findNumber(){
		
		int a;
        System.out.println("How many numbers do you want to enter? ");
        Scanner lenght = new Scanner(System.in);
        a=lenght.nextInt();

        int vector[]= new int[a];

        int smallest = Integer.MAX_VALUE;

        for(int counter=0; counter < a; counter++){
            System.out.println("Enter number "+(counter+1));
            vector[counter]= lenght.nextInt();

        }
        lenght.close();
        for(int in : vector){
            if (in<smallest){
                smallest=in;
            }
        }
        System.out.println("Smallest number is : " +smallest);
		
		
		
	}
}

