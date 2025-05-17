package org.example;

public class Calculator {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int divide(int a, int b) {
        return a / b; // опасно, деление на 0!
    }

    public static int multiply(int a, int b){
        return a * b;
    }
}