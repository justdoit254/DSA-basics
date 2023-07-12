package com.DynamicProgramming;

public class MinimumCoinChange {
    public static void main(String[] args) {
        int[] coins = {25,10,5};
        int sum = 30;
        int n = coins.length;

//        Solution 1 (Recursion)
//        System.out.println(rec(coins, sum, n));

//        Solution 2 (Tabulation)

        int[][] dp = new int[n+1][sum+1];

        for (int j = 0; j < sum+1; j++) {       //(n==0) With zero elements the sum can be made using minimum infinite elements
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        for (int i = 1; i < n+1; i++) {         //(sum==0) Minimum zero elements can generate zero sum
            dp[i][0] = 0;
        }

        for (int i = 1; i < n+1; i++) {         //Using i number of elements
            for (int j = 1; j < sum+1; j++) {   //Generating the sum j
                if (coins[i-1]<=j) {
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }

    private static int rec(int[] coins, int sum, int n) {
        if (sum==0) {
            return 0;
        }
        if (n==0) {
            return Integer.MAX_VALUE - 1;
        }
        if (coins[n-1] <= sum) {
            return Math.min(1+rec(coins, sum-coins[n-1], n), rec(coins, sum, n-1));
        }
        return rec(coins, sum, n-1);
    }
}
