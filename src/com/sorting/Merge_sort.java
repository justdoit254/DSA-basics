package com.sorting;

import java.util.Arrays;

public class Merge_sort {
    public static void main(String[] args) {
        int[] arr = {7,4,1,3};
        int n = arr.length;
        int[] ans = merge_sort(arr,0,n-1);
        System.out.println(Arrays.toString(ans));
//        all_elements(arr);
    }

    private static int[] merge_sort(int[] arr, int start, int end) {
        if (start==end) {
            int[] el = new int[1];
            el[0] = arr[end];
            return el;
        }
        int mid = start+(end-start)/2;
        int[] first = merge_sort(arr,start,mid);
        int[] second = merge_sort(arr,mid+1,end);
        return merge_sorted_array(first,second);
    }

    private static int[] merge_sorted_array(int[] first_arr, int[] second_arr) {
        int n1 = first_arr.length;
        int n2 = second_arr.length;
        int n = n1+n2;
        int[] sorted_arr = new int[n];
        int i = 0, j = 0, k=0;
        while (i< first_arr.length && j< second_arr.length) {
            if (first_arr[i]<=second_arr[j]) {
                sorted_arr[k]=first_arr[i];
                i++;
            }else {
                sorted_arr[k] = second_arr[j];
                j++;
            }
            k++;
        }
        while (i< first_arr.length) {
            sorted_arr[k] = first_arr[i];
            i++; k++;
        }
        while (j< second_arr.length) {
            sorted_arr[k] = second_arr[j];
            j++; k++;
        }
        return sorted_arr;
    }

    private static void all_elements(int[] arr) {
        int n = arr.length;
        if (n==1) {
            int el = arr[0];
            System.out.println(el);
            return;
        }
        all_elements(Arrays.copyOfRange(arr,0,n/2));
        all_elements(Arrays.copyOfRange(arr,n/2,n));
    }
}
