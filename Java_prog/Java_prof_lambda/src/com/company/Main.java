package com.company;

public class Main {

    public static void main(String[] args) {
//	      Operationable operation;
//        operation = (x, y)->x+y;
//
//        int result = operation.calculate(10, 20);
//        System.out.println(result);

        // or
        Operationable op = (x, y, z)->x+y;
        System.out.println(op.calculate(15, 25));
    }
}
