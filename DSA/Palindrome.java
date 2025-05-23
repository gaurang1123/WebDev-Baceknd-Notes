public class Palindrome {
    

    // reverse the number 
    // d =  n %10 -> lastnumber
    // rnum = rnum * 10 + d


    // check if numbers are equal

    public static boolean pal(int n){
        if(n<0){
            return false;
        }
        
        int temp =n;
        int rnum = 0;
        while (temp>0) {
            rnum = rnum*10;
            rnum += temp%10;
            temp = temp /10;
        }
        if (rnum == n) {
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args) {
        int n = 121;
        System.out.println(pal(n));
    }
}
