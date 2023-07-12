package com.sorting;

public class Pivot_of_sorted_array {
    public static void main(String[] args) {
        int[] arr = {20,30,40,50,10};
        int lo = 0;
        int hi = arr.length-1;
        while (lo<hi) {
            int mid = (lo+hi)/2;
            if (arr[mid]<arr[hi]) {
                hi = mid ;
            } else if (arr[mid]>arr[hi]) {
                lo = mid+1;
            } else {
                System.out.println(arr[mid]);
                return;
            }
        }
        System.out.println(arr[hi]);
    }
}
