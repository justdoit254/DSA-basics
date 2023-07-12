package com.recursion;

public class Target_sum_subsets {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int target = 60;
        target_sum_subsets(arr,0,"",target,0);
    }

    private static void target_sum_subsets(int[] arr, int idx, String ans, int tar, int ssf) {
        if (idx == arr.length) {
            if (ssf==tar) {
                System.out.println(ans + ".");
//                return;
            }
            return;
        }

        target_sum_subsets(arr,idx+1,ans + arr[idx] + ",", tar , ssf+arr[idx]);
        target_sum_subsets(arr,idx+1,ans,tar,ssf);
    }
}
