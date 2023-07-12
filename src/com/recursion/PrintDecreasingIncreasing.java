package com.recursion;

public class PrintDecreasingIncreasing {
    public static void main(String[] args) {
        // WAP to print no. in decreasing order (for ex - 5,4,3,2,1) and then in increasing order (for ex - 1,2,3,4,5)
        int n = 5;
        System.out.println("Decreasing counting");
//        decreasing(n);
        System.out.println("Increasing counting");
//        increasing(n-4);
        System.out.println("Both in one function");
        decinc(n);

    }

    private static void decinc(int n) {
        if (n==0) {
            return;
        }
        System.out.println(n);
        decinc(n-1);
        System.out.println(n);
    }

    private static void increasing(int i) {
        if (i>5) {
            return;
        }
        System.out.println(i);
        increasing(i+1);
    }

    private static void decreasing(int n) {
        if (n<1) {
            return;
        }
        System.out.println(n);
         decreasing(n-1);
    }
}
