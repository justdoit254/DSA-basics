package com.array;

public class KadanesAlgo {
    public static void main(String[] args) {
        int[] arr = {-1, 2, -2, 5, 7, -3, 1};
        //Brute force approach
        int n = arr.length;
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum>max_sum) max_sum = sum;
            }
            sum = 0;
        }
//        System.out.println(max_sum);

        //Kadane's Algorithm
        int currentSum = arr[0];
        int overallSum = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            if (currentSum+arr[i]>=arr[i]) currentSum += arr[i];
            else currentSum = arr[i];
            if (currentSum>overallSum) overallSum = currentSum;
        }
        System.out.println(overallSum);
    }
}
