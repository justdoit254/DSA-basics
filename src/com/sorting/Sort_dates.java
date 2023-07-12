package com.sorting;

import java.util.Arrays;

public class Sort_dates {
    public static void main(String[] args) {
        String[] arr = {
                "12041996",
                "20101996",
                "05061997",
                "12041989",
                "11081987"
        };
        sort_dates(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort_dates(String[] arr) {
        count_sort(arr,1000000,100,32);
        count_sort(arr,10000,100,13);
        count_sort(arr,1,10000,2501);
    }

    private static void count_sort(String[] arr, int div, int mod, int range) {
        int n = arr.length;
        int[] count_arr = new int[range];
        //Filling count_arr with frequency of elements;
        for (String el : arr) {
            count_arr[(Integer.parseInt(el)/div)%mod]++;
        }
        //Filling count_arr with prefix sum-1
        int prefix_sum = 0;
        for (int i = 0; i < count_arr.length; i++) {
            prefix_sum+=count_arr[i];
            count_arr[i] = prefix_sum-1;
        }
        String[] ans = new String[n];
        //Now last step is to fill the ans array in increasing order from backward
        for (int i = n-1; i >=0 ; i--) {
            int position = count_arr[(Integer.parseInt(arr[i])/div)%mod];
            ans[position] = arr[i];
            count_arr[(Integer.parseInt(arr[i])/div)%mod] --;
        }
        System.arraycopy(ans, 0, arr, 0, n);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ans));


    }
}
