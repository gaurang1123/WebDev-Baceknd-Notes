public class AllPrime {

    public static void primeChecker(int n){
        // loop for 2 to n
        // for i check if it is prime
        for(int i=2;i<=n;i++){
            boolean isPrime = true;
            for(int j=2;j<=(i-1);j++){
                if(i%j == 0){
                    isPrime = false;
                }
            }
            if(isPrime){
                System.out.println(i);
            }
        }


    }
    public static void main(String[] args) {
        int n=15;
        System.out.println(" ");
        primeChecker(n);
    }
}
