package com.DynamicProgramming;

import java.util.Scanner;

public class ClimbStairsWithVariableJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n-1; i >=0 ; i--) {
            for (int j = i+1; j <= Math.min(n, i+arr[i]); j++) {
                dp[i] += dp[j];
            }
        }
        System.out.println(dp[0]);
    }
}
