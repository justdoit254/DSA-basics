package com.array;

import java.util.Arrays;

public class InverseAnArray {
    public static void main(String[] args) {
        int[] arr = {3,4,1,2,0};
        int n = arr.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int index = arr[i];
            ans[index] = i;
        }
        System.out.println(Arrays.toString(ans));
    }
}
