public class Check {
    static int a =10;

    public void sum(){
        int a=20;
        System.out.println((this.a+10));
    }

    public static void main(String[] args) {
        System.out.println();
     Check obj = new Check();
     obj.sum();   
    }
 
}
