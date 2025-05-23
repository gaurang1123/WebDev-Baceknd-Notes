public class Armstrong {
    
    // sum of digit. each pow with num of digit
    
    public static boolean armstrong(int n){
        int sum = 0;
        int temp=n;
        int temp1=n;
        int len = 0;
        while (temp1>0) {
            int d = temp1%10;
            temp1 = temp1 / 10;
            len++;
        }

        while (temp>0) {
            int d = temp % 10;
            double p = Math.pow(d,len);
            sum+=p;
            temp = temp /10;
        }
        if(n==sum){
            return true; 
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 152;
        System.out.println(" ");
        System.out.println(armstrong(n));
    }
}
