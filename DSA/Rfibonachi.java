public class Rfibonachi {
    
    public static int rFib(int n){
        int f = 0;
        if(n==0){
        return 0;
        }
        else if(n==1){
        return 1;
        }
        else{
            // 2      1           0   
             f = rFib(n-1) + rFib(n-2);
        }
        return f;
    }

    public static void main(String[] args) {
        int n = 2;
        int result = rFib(n);
        System.out.println(result); 
    }
}
