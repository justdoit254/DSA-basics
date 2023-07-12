package com.DynamicProgramming;

import java.util.Scanner;

public class CoinChangeCombinations {
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
        //        First the element of given array is chosen then the dp array is traversed
//        First check for first coin in the whole dp then for second coin and so on.
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j < dp.length; j++) {
                dp[j] += dp[j-arr[i]];
            }
        }
        System.out.println(dp[amt]);
    }
}
