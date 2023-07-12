package com.DynamicProgramming;

import java.util.Scanner;

public class Zero_OneKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        int w = sc.nextInt();

        int[][] dp = new int[n + 1][w+1];

        for (int i = 0; i < n+1; i++) {   // i is representing the n which is the, which is number of weights or values.
            for (int j = 0; j < w+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][w]);

//        int[][] dp = new int[val.length + 1][w + 1];
//        for (int i = 1; i < dp.length; i++) {
//            for (int j = 1; j < dp[0].length; j++) {
//                if (j >= wt[i - 1]) {
//                    int before = dp[i - 1][j];
//                    int self = val[i - 1];
//                    int other = dp[i - 1][j - wt[i - 1]];
//                    if (self + other > before) {
//                        dp[i][j] = self + other;
//                    } else {
//                        dp[i][j] = dp[i - 1][j];
//                    }
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }
//
//            }
//        }
//        System.out.println(dp[val.length][w]);
    }
}
