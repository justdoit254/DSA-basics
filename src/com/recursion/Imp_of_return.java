package com.recursion;

public class Imp_of_return {
    public static void main(String[] args) {

        int m = 2;
        int k = increasedvalue(m);
        System.out.println(k);
    }
    private static int increasedvalue(int m) {
        int value = m;
        value +=2;
        return value;
    }
}
