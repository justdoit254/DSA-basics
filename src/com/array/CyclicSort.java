package com.array;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
//        int[] arr = {3,1,3,4,2};
        int[] arr = {2,2};
        System.out.println(Arrays.toString(sort(arr)));

    }
    static int[]  sort(int[]nums) {
        int i = 0;
        while (i<nums.length){
            int correct = nums[i] - 1;          //remove -1 if elements in array start with 0
            if (nums[i] != nums[correct]) {     //if elements in array starts with 0 then one more condition nums[i]<nums.length
                swap(nums,i,correct);
            }
            else i++;
        }
        return nums;
    }
    static void swap(int[]nums , int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
