package com.DynamicProgramming;

public class RodCutting {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5};      //Value array
//        int n = arr.length;
        int n = 7;

//        Solution 1 (recursive)
//        System.out.println(maxVal(arr,n,n));

//        Solution 2 (Tabulation)
        int[][] dp = new int[n+1][n+1];

        for (int i = 0; i < n+1; i++) {         //Using i number of elements
            for (int j = 0; j < n+1; j++) {     //Creating max val for j elements
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
                else if (i <= j) {
                    dp[i][j] = Math.min(arr[i-1]+dp[i][j-i],dp[i-1][j]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
            for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n+1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(dp[n][n]);

    }

    private static int maxVal(int[] arr, int n, int max_length) {
        if (n==0 || max_length==0) {
            return 0;
        }
        if (n <= max_length) {
            return Math.max(arr[n-1]+maxVal(arr,n,max_length-n),maxVal(arr,n-1,max_length));
        }
        else return maxVal(arr,n-1,max_length);
    }
}
