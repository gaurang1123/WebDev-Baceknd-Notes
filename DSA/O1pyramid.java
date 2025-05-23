public class O1pyramid {
    // public static void main(String[] args) {
    //     System.out.println();
    //     int a=1;
    //     for(int i=1;i<=5;i++){
    //         int n=a;
    //         for(int j=1;j<=i;j++){
    //             if(n == 1){
    //                 System.out.print(n);
    //                 n = 0;
    //             }
    //             else{
    //                 System.out.print(n);
    //                 n=1;
    //             }
    //         }
    //         if(a == 1){
    //             a = 0;
    //         }
    //         else{
    //             a=1;
    //         }
            
    //         System.out.println();
    //     }
    // }

    public static void main(String[] args) {
        int n=1;
        for(int i=1;i<=5;i++){
            if(i%2==0){
                n=0;
            }
            else{
                n=1;
            }
            int a=n;
            for(int j=1;j<=i;j++){
                System.out.print(a);
                if(a==1){
                    a=0;
                }
                else{
                    a=1;
                }
            }
            System.out.println();
        }
    }

}
