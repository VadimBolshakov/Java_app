package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        int counter = (int) IntStream.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5).filter(x -> x>0).count();
        System.out.println(counter);

        ArrayList<String> cities = new ArrayList<String>();
        Collections.addAll(cities, "Paris", "London", "Rome");
        cities.stream().filter(s -> s.length()>4).forEachOrdered(s -> System.out.println(s));
    }
}
