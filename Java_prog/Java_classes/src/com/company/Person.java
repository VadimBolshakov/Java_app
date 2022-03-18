package com.company;

public class Person {
    public     int height;
    private String name;

    public  void say(){
        System.out.println("Hello "+name);
    }

    public Person(int height, String name) {
        this.height = height;
        this.name = name;
    }

    public Person(String name) {
        this.height = 180;
        this.name = name;
    }

    public Person() {}
}
