package com.DynamicProgramming;

import java.util.Scanner;

public class MinimumCostInMazeTraversal {
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
//        Traversing across the row i.e last row then second last row and so on
        for (int r = n-1; r >=0 ; r--) {
            for (int c = m-1; c >=0 ; c--) {
                int min = Integer.MAX_VALUE;
                int el = arr[r][c];
                if (r+1<n && dp[r+1][c]<min) min = dp[r+1][c];
                if (c+1<m && dp[r][c+1]<min) min = dp[r][c+1];
                if (min!=Integer.MAX_VALUE) el += min;
                dp[r][c] = el;
            }
        }
        System.out.println(dp[0][0]);
    }
}
