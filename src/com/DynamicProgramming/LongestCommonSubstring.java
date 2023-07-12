package com.DynamicProgramming;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String x = "abcdgh";
        String y = "acdghr";
        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans = Math.max(ans, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        System.out.println(ans);
    }
}
