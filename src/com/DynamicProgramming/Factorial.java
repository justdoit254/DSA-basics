package com.DynamicProgramming;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n+1];
        int fib = FibMemoized(n, dp);
        System.out.println(fib);
    }

    private static int FibMemoized(int n, int[] dp) {
        if (n==0 || n==1) {
            return n;
        }
        if (dp[n]!=0) {
            return dp[n];
        }

        int n1 = FibMemoized(n-1, dp);
        int n2 = FibMemoized(n-2, dp);
        int fibn = n1 + n2;

        dp[n] = fibn;
        return fibn;
    }
}
