package com.sorting;

import java.util.Arrays;

public class Radix_sort {
    public static void main(String[] args) {
        int[] arr = {213,97,718,123,37,443,982,64,375,683};
        int n_arr = arr.length;
        int max_arr = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j>max_arr) max_arr = j;
        }
        int exp = 1;
        while (exp<max_arr) {
            count_sort(arr,exp);
            exp *= 10;
        }
    }

    private static void count_sort(int[] arr, int exp) {
        int n = arr.length;
//        //Finding minimum element
//        int min = Integer.MAX_VALUE;
//        for (int k : arr) {
//            if (k < min) min = k;
//        }
//        //Finding maximum element
//        int max = Integer.MIN_VALUE;
//        for (int j : arr) {
//            if (j > max) max = j;
//        }
        //Make count arr
        int[] count_arr = new int[10];
        //Filling count_arr with frequency of elements;
        for (int el : arr) {
            count_arr[(el/exp)%10]++;
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
//            int el = arr[i];
//            int idx = el-min;
            int position = count_arr[(arr[i]/exp)%10];
            ans[position] = arr[i];
            count_arr[(arr[i]/exp)%10] --;
        }
         System.arraycopy(ans, 0, arr, 0, n);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ans));
    }
}
