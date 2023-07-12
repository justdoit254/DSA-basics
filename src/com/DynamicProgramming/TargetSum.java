package com.DynamicProgramming;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1};
        int n = arr.length;
        int target = 1;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }


        if ((sum-target)<0 || (sum+target)%2 !=0) {
            System.out.println(0);
            return;
        }
        int reqSum = (sum+target)/2;

       int[][] dp = new int[n+1][reqSum+1];
        dp[0][0] = 1;
        for (int j = 1; j < reqSum+1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < reqSum+1; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }
           for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < reqSum+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[n][reqSum]);
    }
}
