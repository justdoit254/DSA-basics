package com.DynamicProgramming;

import java.util.Scanner;

public class PathWithMaximumGold {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[][] dp = new int[n][m];
//        Traversing across the column i.e last column then second last column and so on
        for (int c = m-1; c >= 0 ; c--) {
            for (int r = n-1; r >= 0 ; r--) {
                int el = 0;
                if (c+1 == m) {
                    el = 0;
                } else if (r+1 == n) {
                    el = Math.max(dp[r-1][c+1],dp[r][c+1]);
                } else if (r == 0) {
                    el = Math.max(dp[r][c+1],dp[r+1][c+1]);
                } else {
                    el = Math.max(dp[r-1][c+1],Math.max(dp[r][c+1],dp[r+1][c+1]));
                }
                el += arr[r][c];
                dp[r][c] = el;

            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i][0]>max) max = dp[i][0];
        }
        System.out.println(max);
    }
}
