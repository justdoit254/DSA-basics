package com.recursion;

import java.util.Arrays;

public class All_indices_in_array {
    public static void main(String[] args) {
        int[] arr = {5,3,2,3,9,7};
        int target = 3;
        System.out.println(Arrays.toString(find_all_index(arr, target, 0, 0)));
    }

    private static int[] find_all_index(int[] arr, int target, int idx, int i) {
        if (idx==arr.length) {
            return new int[i];
        }
        int[] ans;
        if (arr[idx]==target) {
            ans = (find_all_index(arr,target,idx+1,i+1));
            ans[i] = idx;

        }else {
            ans = (find_all_index(arr,target,idx+1,i));
        }
        return ans;
    }
}
