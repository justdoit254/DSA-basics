package com.sorting;

import java.util.Arrays;

public class Quick_select {
    public static void main(String[] args) {
        int[] arr = {6,3,8,1,5,4,2,7};
//        int[] arr = {7,-2,4,1,3};
        int n = arr.length;
        int k = 4;
        int kth_smallest = quick_select(arr,k-1,0,n-1);
        System.out.println(kth_smallest);
    }

    private static int quick_select(int[] arr, int k, int s, int e) {
        int pivot = arr[e];
       int pivot_idx = partitioned_arr(arr,pivot,s,e);
       if (k<pivot_idx) {
           return (quick_select(arr,k,s,pivot_idx-1));
       }else if (k>pivot_idx) {
           return (quick_select(arr,k,pivot_idx+1,e));
       }
//       return arr[pivot_idx];
        return  pivot;
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
        System.out.println(Arrays.toString(partitioned_arr));
        return j-1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
