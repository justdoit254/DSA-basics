package com.array;

import java.util.Arrays;

public class ShellRotate {
    public static void main(String[] args) {
        int[][] arr ={
                {11,12,13,14,15,16},
                {21,22,23,24,25,26},
                {31,32,33,34,35,36},
                {41,42,43,44,45,46},
                {51,52,53,54,55,56},
                {61,62,63,64,65,66}
        };
        int s = 2;
        int r = 2;
        rotateShell(arr,r,s);
        displayShell(arr);
    }

    public static void displayShell(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void rotateShell(int[][] arr, int r, int s) {
        int[] one_d_arr = fillonedfromshell(arr,s);
        rotate(one_d_arr,r);
        fillshellfromoned(arr,s,one_d_arr);
    }

    public static void fillshellfromoned(int[][] arr, int s, int[] one_d_arr) {
        int minr = s-1;
        int minc = s-1;
        int maxr = arr.length-s;
        int maxc = arr[0].length-s;
        int index = 0;
        for (int i = minr,j=minc; i <= maxr; i++) {
            (arr[i][j]) = one_d_arr[index];
            index++;
        }for (int i = maxr,j=minc+1; j <= maxc; j++) {
            (arr[i][j]) = one_d_arr[index];
            index++;
        }for (int i = maxr-1,j=maxc; i >= minr; i--) {
            (arr[i][j]) = one_d_arr[index];
            index++;
        }for (int i = minr,j=maxc-1; j > minc; j--) {
            (arr[i][j]) = one_d_arr[index];
            index++;
        }
    }

    public static void rotate(int[] one_d_arr, int r) {
        int n = one_d_arr.length;
        int k = r;
        reverse(one_d_arr,0,n-k-1);
        reverse(one_d_arr, n-k, n-1);
        reverse(one_d_arr, 0, n-1);
    }

    public static void reverse(int[] one_d_arr, int start, int end) {
        while (start<end) {
            int temp = one_d_arr[start];
            one_d_arr[start] = one_d_arr[end];
            one_d_arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] fillonedfromshell(int[][] arr, int s) {
        int minr = s-1;
        int minc = s-1;
        int maxr = arr.length-s;
        int maxc = arr[0].length-s;
        int size = 2*(maxr-minr) + 2*(maxc-minc);
        int[] oned = new int[size];
        int index = 0;
        for (int i = minr,j=minc; i <= maxr; i++) {
            oned[index] = (arr[i][j]);
            index++;
        }for (int i = maxr,j=minc+1; j <= maxc; j++) {
            oned[index] = (arr[i][j]);
            index++;
        }for (int i = maxr-1,j=maxc; i >= minr; i--) {
            oned[index] = (arr[i][j]);
            index++;
        }for (int i = minr,j=maxc-1; j > minc; j--) {
            oned[index] = (arr[i][j]);
            index++;
        }
        return oned;

    }
}
