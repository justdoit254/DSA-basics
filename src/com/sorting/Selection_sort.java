package com.sorting;

import java.util.Arrays;

public class Selection_sort {
    public static void main(String[] args) {
        int[] arr = {7,-2,4,1,3};
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_index = i;
            int j = i;
            for ( ; j < arr.length; j++) {
                if (arr[j]<min) {
                    min = arr[j];
                    min_index = j;
                }
            }
            swap(arr,i,min_index);
        }
        System.out.println(Arrays.toString(arr));
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
