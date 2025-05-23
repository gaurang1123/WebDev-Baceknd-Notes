public class SumOfDigits {

    public static int sumn(int n){
        int len = String.valueOf(n).length();
        int sum= 0;
        int temp = n;
        for(int i=0;i<len;i++){
            int d = temp % 10;
            sum +=d ;
            temp = temp/10;
        }

        return sum;
    }
    public static void main(String[] args) {
        int n = 234;
        System.out.println(" ");
        System.out.println(sumn(n));
    }
}
