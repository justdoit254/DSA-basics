package com.sorting;

import java.util.Arrays;

public class Count_sort {
    public static void main(String[] args) {
        int[] arr = {9,6,3,5,3,4,3,9,6,4,6,5,8,9,9};
        int n = arr.length;
        //Finding minimum element
        int min = Integer.MAX_VALUE;
        for (int k : arr) {
            if (k < min) min = k;
        }
        //Finding maximum element
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) max = j;
        }
        int[] count_arr = new int[max-min+1];
        //Filling count_arr with frequency of elements;
        for (int el : arr) {
            count_arr[el-min]++;
        }
        //Filling count_arr with prefix sum-1
        int prefix_sum = 0;
        for (int i = 0; i < count_arr.length; i++) {
            prefix_sum+=count_arr[i];
            count_arr[i] = prefix_sum-1;
        }
        int[] ans = new int[n];
        //Now last step is to fill the ans array in increasing order from backward
        for (int i = n-1; i >=0 ; i--) {
            int el = arr[i];
            int idx = el-min;
            int position = count_arr[idx];
            ans[position] = el;
            count_arr[idx] = count_arr[idx]-1;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ans));

    }
}
