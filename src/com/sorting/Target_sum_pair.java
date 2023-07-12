package com.sorting;

import java.util.Arrays;

public class Target_sum_pair {
    public static void main(String[] args) {
        int[] arr = {7,15,3,18,6,4,19,2,12,11,9};
        int n = arr.length;
        int target = 15;
        Arrays.sort(arr);
        int i = 0;
        int j = n-1;
        while (i<=j) {
            if (arr[i]+arr[j]>target) {
                j--;
            } else if (arr[i]+arr[j]<target) {
                i++;
            } else {
                System.out.println(arr[i] + "," +arr[j]);
                i++; j--;
            }
        }
    }
}
