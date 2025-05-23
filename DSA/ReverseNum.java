public class ReverseNum {

    public static int reverse(int n) {
        int temp = n;
        int rnum = 0;
        while (temp>0) {
            int d = temp%10;
            rnum = (rnum * 10)+ d;
            temp /= 10; 
        }
        return rnum;
    }
    public static void main(String[] args) {
        int n=1122;
        System.out.println(reverse(n));
    }
}