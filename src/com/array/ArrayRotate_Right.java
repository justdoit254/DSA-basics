package com.array;

import java.util.Arrays;

public class ArrayRotate_Right {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;
        int k = 2;
        reverse(arr,0,n-k-1);
        System.out.println(Arrays.toString(arr));
        reverse(arr, n-k, n-1);
        System.out.println(Arrays.toString(arr));
        reverse(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void reverse(int[] arr,int start,int end) {
        while (start<end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

    }
}
