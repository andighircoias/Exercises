import java.util.Scanner;

public class Polidrom {

    public static void main(String[] args) {
       findifPolidrom();
    }


    public static void findifPolidrom(){
        int a, sum=0, b;
        System.out.println("Enter a random number: ");
        Scanner sca = new Scanner(System.in);
        int n= sca.nextInt();
        b=n;
        while(n>0){
            a=n%10;
            sum=(sum*10)+a;
            n=n/10;
        }
        if(b==sum){
            System.out.println("Number is polidrome.");

        }else{
            System.out.println("Number is not polidrome.");
        }
    }
}
