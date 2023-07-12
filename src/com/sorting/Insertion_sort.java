package com.sorting;

import java.util.Arrays;

public class Insertion_sort {
    public static void main(String[] args) {
        int[] arr = {2,9,5,1,3};
        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            int num = arr[i];
//            int idx = i;
//            for (int j = i-1; j >=0 ; j--) {
//                if (num<arr[j]) {
//                    swap(arr,idx,j);
//                    idx = j;
//                }
//            }
//        }
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if (arr[j]>arr[j+1]) {
                    swap(arr,j,j+1);
                }

            }

        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
