package com.DynamicProgramming;

import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] arr = {1,2,3,1,2};
        int n = arr.length;
        int sum = 9;

//        Method 1 --> Recursion
//        boolean ans = isTarget(arr, sum, n);
//        System.out.println(ans);

//        Method 2 --> Bottom-up
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int j = 0; j < sum+1; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static boolean isTarget(int[] arr, int sum, int n) {
        if (sum == 0) {
            return true;
        }
        if (n==0) {
            return false;
        }
        if (arr[n-1] > sum) {
            return isTarget(arr, sum, n-1);
        }
        return isTarget(arr, sum-arr[n-1],n-1) || isTarget(arr, sum, n-1);
    }
}
