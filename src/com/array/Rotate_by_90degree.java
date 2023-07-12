package com.array;

import java.util.Arrays;

public class Rotate_by_90degree {
    public static void main(String[] args) {
        int[][] arr = {
                {11,12,13,14},
                {21,22,23,24},
                {31,32,33,34},
                {41,42,43,44}
        };
        int n = arr.length;
        int m = arr[0].length;
        //Transpose
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
//                ans[i][j] = arr[j][i];
            }
        }
//       Reversing the transpose array (like 1-D array)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[0].length/2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][m-1-j];
                arr[i][m-1-j] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
