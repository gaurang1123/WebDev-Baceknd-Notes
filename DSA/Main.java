import java.util.Scanner;

public class Main {

    public static int fact(int a){
        int f = 1;
        for(int i=1;i<=a;i++){
            f=f*i;
        }
        return f;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n =5;
        int r =2;
        int bi = fact(n)/(fact(r)*fact(n-r));
        System.out.println(bi);
    }
}