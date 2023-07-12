package com.DynamicProgramming;

import java.util.Scanner;

public class ClimbStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int[] dp = new int[n+1];
//        int paths = countPaths(n, dp);
        int paths = countPathsTab(n);
        System.out.println(paths);

    }

    private static int countPathsTab(int n) {
        if (n==0) {
            return 1;
        } else if (n<0) {
            return 0;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <=n ; i++) {
            dp[i] = dp[i-1];
            if (i>=2) {
                dp[i] += dp[i-2];
            }
            if (i>=3) {
                dp[i] += dp[i-3];
            }

        }
        return dp[n];
    }

    private static int countPaths(int n, int[] dp) {
        if (n==0) {
            return 1;
        } else if (n<0) {
            return 0;
        }

        if (dp[n]!=0) {
            return dp[n];
        }

        int p1 = countPaths(n-1, dp);
        int p2 = countPaths(n-2, dp);
        int p3 = countPaths(n-3, dp);
        int tp = p1 + p2 + p3;
        dp[n] = tp;
        return tp;
    }
}
