package java_prof_2;


public class Java_prof_2 {


    public static void main(String[] args) {
        int arr[] = {12, 45, 52};
        try {
            
            System.out.print(arr[3]);
            int x = 100 / 0;
        } catch(ArithmeticException e){
            System.out.println("Error:" + e);
        } catch(Exception e){
            System.out.println("Error:" + e);
        } finally {
            System.out.println("Funally is working");
        }
        System.out.println("Continue");
    }
    
}
