package com.sorting;

import java.util.Arrays;

public class Sort_01 {
    public static void main(String[] args) {
        // The ques is same as DutchNationalFlagAlgo except there 0,1&2 are sorted and here only 0&1
        int[] arr = {0,1,1,0,1,1,0,0,1};
        int n = arr.length;
        int i = 0, j = 0;
        while (i<n) {
            if (arr[i]==0) {
                swap(arr,i,j);
                i++; j++;
            }else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

