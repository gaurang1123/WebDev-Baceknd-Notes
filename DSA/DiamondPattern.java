public class DiamondPattern {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println("w");
        int n=4;
        for(int i=1;i<=n;i++){
            for(int s=n;s>i;s--){System.out.print(" ");}
            for(int j=1;j<=((i*2)-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }


        for(int i=n;i>=1;i--){
            for(int s=n;s>i;s--){System.out.print(" ");}
            for(int j=1;j<=((i*2)-1);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
