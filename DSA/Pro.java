import java.util.Scanner;


// Write a program that reads a set of integers, and then prints the sum of the even and odd integers
public class Pro{
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);   

            int num;
            int choice = 0;
            int evenSum = 0;
            int oddSum = 0;

            do{
                System.out.print("Enter a number: ");
                num = scanner.nextInt();

                if(num %2 == 0){
                    evenSum+=num;
                }
                else{
                    oddSum += num;
                }

                System.out.println("Enter 1 to continue 0 to break: ");
                choice = scanner.nextInt();
            }
            while(choice>0);

            System.out.println(" ");
            System.out.println(evenSum);
            System.out.println(oddSum);

        }
} 
