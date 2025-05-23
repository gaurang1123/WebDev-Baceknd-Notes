public class HollowRohumbusPattern {
    public static void main(String[] args) {

        System.out.println();
        for(int i=5;i>0;i--){
        for(int s=0;s<i-1;s++){System.out.print(" ");}
        for(int j=0;j<5;j++){
            if(i==5 || i==1 || j==4 || j==0){
                System.out.print("*");
            }
            else{ System.out.print(" ");}
        }
        System.out.println();
        } 
    }
}

