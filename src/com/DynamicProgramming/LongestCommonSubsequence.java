package com.DynamicProgramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String x = "acbcf";
        String y = "abcdaf";
        int n = x.length();
        int m = y.length();
        String ans = "";
        
//        Solution 1 (recursion)
        System.out.println(lcs(x,y,n,m));

//        Solution 2 (tabulation)
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (x.charAt(i-1) == y.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    ans += x.charAt(i-1);
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);
        System.out.println(ans);
    }

    private static int lcs(String x, String y, int n, int m) {
        if (n==0 || m==0) {
            return 0;
        }
        if (x.charAt(n-1) == y.charAt(m-1)) {
            return 1+lcs(x, y, n-1, m-1);
        }
        else {
            return Math.max(lcs(x, y, n, m-1),lcs(x, y, n-1, m));
        }
    }
}
