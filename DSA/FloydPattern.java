public class FloydPattern {
    public static void main(String[] args) {
        int n=1;
        System.out.println(" ");
        for(int i=1;i<=5;i++){
            for(int j=1;j<=i;j++){
                System.out.print(n++);
            }
            System.out.print("\n");
        }
    }
}
