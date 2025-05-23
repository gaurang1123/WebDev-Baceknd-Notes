public class PrimeNumber {

    public static boolean primeCheck(int n){
        for(int i=2;i<=(n-1);i++){
            if (n%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n =9;
        System.out.println("");
        System.out.println(primeCheck(n));
    }
}
