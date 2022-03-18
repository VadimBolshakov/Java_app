package interface_java;

class Some implements Runnable {

    @Override
    public void run() {
        for (int i=0; i<10; i++)
            System.out.println("Number_2 = "+ i);
    }
}       


public class Inter {
    public static void main (String[] args) {
        Thread new_one = new Thread(new Some());
        //Runnable new_two = new Thread(new Some());
        Thread new_two = new Thread(new Some());
        new_one.start();
        new_two.start();
    }
    
}
