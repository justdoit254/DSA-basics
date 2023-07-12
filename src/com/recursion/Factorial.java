package com.recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 5;
        int fact = find_factorial(n);
        System.out.println(fact);
    }

    private static int find_factorial(int n) {
        if (n<2) {
            return 1;
        }
        return n*find_factorial(n-1);

    }
}
