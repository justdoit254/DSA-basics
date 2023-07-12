package com.DynamicProgramming;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int sum = 4;
        int n = coins.length;

//        Solution 1 (recursive)
        System.out.println(validSum(coins,n,sum));

//        Solution 2 (tabulation)
        int[][] dp = new int[n+1][sum+1];

        for (int j = 0; j < sum+1; j++) {       //(n==0) With zero elements the sum will always be zero
            dp[0][j] = 0;
        }
        for (int i = 0; i < n+1; i++) {         //(sum==0) Any number of elements can generate zero sum
            dp[i][0] = 1;
        }

        for (int i = 1; i < n+1; i++) {         //Using i number of elements
            for (int j = 1; j < sum+1; j++) {   //Generating the sum j
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][sum]);
    }

    private static int validSum(int[] coins, int n, int sum) {
        if (n==0) {
            return 0;
        }
        if (sum==0) {
            return 1;
        }
        if (coins[n-1] <= sum) {
            return validSum(coins,n,sum-coins[n-1]) + validSum(coins, n-1, sum);
        }
        else {
            return validSum(coins, n-1, sum);
        }
    }
}
