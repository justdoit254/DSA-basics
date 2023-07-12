package com.DynamicProgramming;

public class CountOfSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1,6,11,5};
        int sum = 23;

        int n = arr.length;
        int[][] dp = new int[n+1][sum+1];
        dp[0][0] = 1;
        for (int j = 1; j < sum+1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }
        System.out.println(dp[n][sum]);
               for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
