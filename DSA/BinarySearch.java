import java.util.Scanner;

public class BinarySearch {
    
    public static int binsearch(int arr[],int n){
        int left =0;
        int right = arr.length - 1;
        while(left<=right){
            int mid =  (left+right)/2;
            System.out.println("mid"+arr[mid]);
            if(n==arr[mid]){
                return mid;
            }
            if(arr[mid]<n){
                left = mid+1; 
            }
            else if(arr[mid]>n){
                right = mid-1;
            }
            System.out.println("left "+left+" Right"+right);
        }        
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,33,45,68,88,132,335};
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("ENTER INT: ");
        int n =sc.nextInt();
        System.out.println("Element Found at: "+ binsearch(arr,n));
    }
}
