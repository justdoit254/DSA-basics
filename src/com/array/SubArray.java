package com.array;

import java.util.Arrays;

public class SubArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-i; j++) {
                for (int k = j; k < j+i+1 ; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }
}
