package org.example;



public class Main {

    public static int checkEven(int n){
        if (n % 2 == 0){
            return 1;
        }
        return 0;
    }

    public static boolean isShort(String str){
        return str.length() <= 5;
    }


}