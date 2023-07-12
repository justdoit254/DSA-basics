package com.DynamicProgramming;

import java.util.Scanner;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        int cap = sc.nextInt();

        int[] dp = new int[cap + 1];
        dp[0] = 0;
//        First complete work is done on one index of dp array then on second index and so on
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (i >= weight[j]) {
                    int prevIdx = i - weight[j];
                    int prevPrice = dp[prevIdx];
                    int currPrice = price[j];
                    int totalPrice = prevPrice + currPrice;
                    if (totalPrice > max) {
                        max = totalPrice;
                    }
                }
            }
            dp[i] = max;
        }
        System.out.println(dp[cap]);
    }
}
