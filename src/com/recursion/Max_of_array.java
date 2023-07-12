package com.recursion;

public class Max_of_array {
    public static void main(String[] args) {
        int[] arr = {5,8,6,3,4,9,7,2};
        System.out.println(find_max1(arr,0));
        System.out.println(find_max2(arr,0));
    }

    private static int find_max2(int[] arr, int i) {
        if (i==arr.length-1) return arr[i];
        int msa = find_max2(arr,i+1);
        if (msa<arr[i]) return arr[i];
        else return msa;

    }

    static int max = 0;

    private static int find_max1(int[] arr, int idx) {
        if (idx==arr.length) return max;
        if (arr[idx]>max) max = arr[idx];
        return find_max1(arr,idx+1);

    }
}
