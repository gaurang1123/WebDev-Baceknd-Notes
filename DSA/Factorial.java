public class Factorial {

    public static int fact(int n){
        int f =1;
        for(int i=1;i<=n;i++){
            f=f*i;
        }        
        return f;
    }
    
    public static int rfact(int n){
        if (n==0 || n==1) {
            return 1;
        }
        else{
            int fact = n * rfact(n-1);
            return fact;
        }
    }


    public static void main(String[] args) {
     
        int n=4;
        System.out.println(fact(n));
        System.out.println(rfact(n));      
    }
}