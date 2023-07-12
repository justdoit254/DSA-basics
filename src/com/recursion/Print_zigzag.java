package com.recursion;

public class Print_zigzag {
    public static void main(String[] args) {
        int n = 3;
        zigzag(n);
    }

    private static void zigzag(int n) {
        if (n==0) {
            return;
        }
        System.out.print(n);
        zigzag(n-1);
        System.out.print(n);
        zigzag(n-1);
        System.out.print(n);
    }
}
