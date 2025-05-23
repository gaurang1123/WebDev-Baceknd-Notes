public class Butterfly {
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        int n=8;
        for(int i=1;i<=n/2;i++){
            int s = i*2;
            int spaces = n - s;
                for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
                for(int j=1;j<=spaces;j++){
                    System.out.print(" ");
                }
                for(int j=1;j<=i;j++){
                    System.out.print("*");
                }
            System.out.println();
        }
        for(int i=n/2;i>=1;i--){
            int s = i*2;
            int spaces = n -s;
            int sside = s/2;
                for(int j=1;j<=sside;j++){
                    System.out.print("*");
                }
                for(int j=1;j<=spaces;j++){
                    System.out.print(" ");
                }
                for(int j=1;j<=sside;j++){
                    System.out.print("*");
                }
            System.out.println();
        }
    }
}

// stars =row*2
// spaces = (2n-stars)
// stars on one side = s/2