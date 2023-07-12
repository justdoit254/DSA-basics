package com.array;

import java.util.Arrays;

public class DuchNationalFlagAlgo {
    public static void main(String[] args) {
        int[] arr = {1,1,2,2,0,1,2,2,1,0,1,2,0,2,1};
        //Three-way Partitioning
        int i = 0;
        int j = 0;
        int k = arr.length-1;
        while(i<=k && j<=i) {
            if (arr[i]==0) {
                swap(arr,i,j);
                j++;
                i++;
            }
            else if (arr[i]==1) {
                i++;
            }
            else if (arr[i]==2)  {
                swap(arr,i,k);
                k--;
            }
        }
        //Two-pass Algorithm
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        for (int value : arr) {
            if (value == 0) i1++;
            if (value == 1) j1++;
            if (value == 2) k1++;
        }
        for (int l = 0; l < arr.length; l++) {
            if (i1>0) {
                arr[l] = 0;
                i1--;
            }else if (j1>0) {
                arr[l] = 1;
                j1--;
            }else {
                arr[l] = 2;
                k1--;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

     static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
