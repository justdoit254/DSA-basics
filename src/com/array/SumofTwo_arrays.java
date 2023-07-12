package com.array;

public class SumofTwo_arrays {
    public static void main(String[] args) {
        int[] arr1 = {9,3,4,6,8};
        int[] arr2 = {1,9,8,8};
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] arr;
        int r = 0 , q = 0 , i = 0 , j = 0;
        if (n1>=n2) {
             i = arr1.length-1;
             j = arr2.length-1;

        }else {
            i = arr2.length-1;
            j = arr1.length-1;
        }
        while (j>=0 && i>=0) {
            int sum = q+arr1[i]+arr2[j];
            q = sum/10;
            r = sum%10;
        }

    }
}
