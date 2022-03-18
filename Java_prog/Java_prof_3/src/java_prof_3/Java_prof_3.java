package java_prof_3;

class SomeThread extends Thread {
    
    public void run() {
        for (int i=0; i<10; i++)
            System.out.println("Number = "+ i);
}
}
public class Java_prof_3 {
    
    public static void main(String[] args) {

        SomeThread test = new SomeThread();
        test.start();
        
        SomeThread test1 = new SomeThread();
        test1.start();
        
        Thread test3 = new Thread(new Runnable () {
            @Override
            public void run() {
                for (int i=0; i<10; i++)
                System.out.println("Number_3 = "+ i);
            }
        });
        
        test3.start();
    }
    
}
