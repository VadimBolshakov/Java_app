package com.company;

public class Main {

    public static void main(String[] args) {
        Person vitya = new Person(150, "Vitya");
        System.out.println(vitya.height);
        vitya.say();
        System.out.println("");

        Student freshman = new Student(85,"Vera", 4);
        System.out.println(freshman.height);
        freshman.tell();
    }
}
