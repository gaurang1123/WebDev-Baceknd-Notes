import java.util.Scanner;

public class LinearSearch {

    public static int findel(int arr[],int n){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==n){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[]={30,23,1,55,42,8,63,9,2};
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to find: ");
        int n = sc.nextInt();
        System.out.println(findel(arr,n));
    }
}
