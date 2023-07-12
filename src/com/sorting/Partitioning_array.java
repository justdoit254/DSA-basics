package com.sorting;

import java.util.Arrays;

public class Partitioning_array {
    public static void main(String[] args) {
         int[] arr = {7,9,4,8,6,3,2,1};
         int n = arr.length;
         int pivot = 5;
         //Method 1
         int i = 0, j = 0;
         while (i< arr.length) {
             if (arr[i]>pivot) {
                 i++;
             }else {
                 swap(arr,i,j);
                 i++; j++;
             }
         }
        System.out.println(Arrays.toString(arr));

        //Method 2 (My)
         int p = 0, q = n-1;
         while (p<=q) {
             if (arr[p]>pivot) {
                 swap(arr,p,q);
                 q--;
             }else if (arr[p]<pivot) {
                 p++;
             } else {
                 swap(arr,p,q);
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
