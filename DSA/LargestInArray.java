import java.util.*;

public class LargestInArray {
    
    public static int findlargest(int arr[]){
        int n=Integer.MIN_VALUE;
        System.out.println(n);
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>n){
                n=arr[i];
            }
        }
        return n;
    }
    public static void main(String[] args) {
        int arr[]={30,23,1,55,42,8,99,63,9,2};
        System.out.println(findlargest(arr));    
    }

}
