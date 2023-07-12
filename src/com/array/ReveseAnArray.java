package com.array;

import java.util.Arrays;

public class ReveseAnArray {
    public static void main(String[] args) {
        int[] arr1 = {10,20,30,40,50,60};
        int n = arr1.length;
        for (int i = 0; i < n/2; i++) {
            int temp = arr1[i];
            arr1[i] = arr1[n-1-i];
            arr1[n-1-i] = temp;
        }
        System.out.println(Arrays.toString(arr1));

    }
}
