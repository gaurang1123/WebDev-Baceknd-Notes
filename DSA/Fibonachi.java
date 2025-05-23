public class Fibonachi {
    
    // start from f =0, prev f-1  

    public static void fib(int n){
        if(n==0){
            System.out.println(0);
            return;
        }
        else if(n==1){
            System.out.println(1);
            return;
        }
        else{
            int a = 0;
            int b = 1;
            int f = 0;
            for(int i=0 ; i<n;i++){
                System.out.println(a);
                f = a+b;
                a=b;
                b=f;
            }
        }
    }


    public static void main(String[] args) {
        int n = 5;
        fib(n);
    }
}
