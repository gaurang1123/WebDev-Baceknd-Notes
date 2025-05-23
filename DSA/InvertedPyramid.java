public class InvertedPyramid {
    

    public static void main(String[] args) {
        for(int i=4;i>=1;i--){
            int s = i-1;
            for(int j=1;j<=4;j++){
                if(s>=j){
                    System.out.print(" ");
                }
                else{
                    System.out.print("*");
                }
            }

            System.out.print("\n");
        }
    }
}
