package com.example.chapter_7_2;

public class Product {
    private String name;
    private int count;
    private String unit;

    Product(String name, String unit){
        this.name=name;
        this.count=0;
        this.unit=unit;
    }
    public String getUnit(){
        return this.unit;
    }

    public String getName()  {
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getCount(){
        return this.count;
    }

    public void setCount(int count){
        this.count=count;
    }
}
