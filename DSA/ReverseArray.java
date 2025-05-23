public class ReverseArray {
    
    public static int revar(int arr[]){
        int left = 0;
        int right = arr.length-1;
        while (left<=right) {
            int temp=arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            right--;
            left++;   
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        return 0;
    }
    public static void main(String[] args) {
        int arr[]={30,23,1,55,42,8,99,63,9,2};
        System.out.println();
        revar(arr);
    }
}
