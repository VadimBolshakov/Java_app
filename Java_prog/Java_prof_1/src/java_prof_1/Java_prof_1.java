package java_prof_1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Java_prof_1 {

    public static void main(String[] args) {
        int some[] = new int[4];
        
        ArrayList<Integer> some_din = new ArrayList<>(5);
        some_din.add(56);
        some_din.add(6);
        some_din.add(8);
        some_din.add(76);
        some_din.add(12);
        some_din.add(9);
        
        for(Integer x : some_din){
            System.out.println(x);
        }
        System.out.println("Length array: "+some_din.size());
        
        some_din.remove(1);
        some_din.remove(new Integer(12));
        
        for(Integer x : some_din){
            System.out.println(x);
        }
        System.out.println("Length array: "+some_din.size());
        
        LinkedList<String> name = new LinkedList<>();
        name.add("Tom");
        name.add("Geoger");
        name.add("Maria");
        name.add("John");
        
        name.add(1, "Alex");
    
        for(String x : name){
            System.out.println(x);
        }
        System.out.println("Length array: "+name.size());
        
        name.remove(1);
        name.remove(new String("John"));
        
        for(String x : name){
            System.out.println(x);
        }
        System.out.println("Length array: "+name.size());
    }
    
}
