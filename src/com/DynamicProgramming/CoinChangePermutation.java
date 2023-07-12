package com.DynamicProgramming;

import java.util.Scanner;

public class CoinChangePermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int amt = sc.nextInt();

        int[] dp = new int[amt+1];
        dp[0] = 1;
//        First the dp array is chosen and its index is filled for all the values in the array
//        Check for all coins in the first element of dp then for all coins in the second element of dp and so on.
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < n; j++) {
                if (i>=arr[j]) {
                    dp[i] += dp[i-arr[j]];
                }
            }
        }
        System.out.println(dp[amt]);
    }
}
