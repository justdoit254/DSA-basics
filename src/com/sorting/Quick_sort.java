package com.sorting;

import java.util.Arrays;

public class Quick_sort {
    public static void main(String[] args) {
        int[] arr = {2,8,9,6,4,3,7,5};
        int n = arr.length;
        int[] ans= quick_sort(arr,0,n-1);
        System.out.println(Arrays.toString(ans));
//        System.out.println(Arrays.toString(arr));
//        quick_sort(arr,0,n-1);
//        System.out.println(Arrays.toString(arr));
    }

    private static int[] quick_sort(int[] arr, int s, int e) {
        if (s>=e) {
            return arr ;
        }

        int pivot = arr[e];     //Taking last element a pivot
        int pivot_idx = partitioned_arr(arr,pivot,s,e);
        quick_sort(arr,0,pivot_idx-2);
        quick_sort(arr,pivot_idx,e);
        return arr;

    }

    private static int partitioned_arr(int[] partitioned_arr, int pivot, int start, int end) {
        int i = start, j = start;
        while (i<= end) {
            if (partitioned_arr[i]>pivot) {
                i++;
            }else {
                swap(partitioned_arr,i,j);
                i++; j++;
            }
        }
        return j;   // it is the index of element next to pivot element so, new index of pivot element is j-1;
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
