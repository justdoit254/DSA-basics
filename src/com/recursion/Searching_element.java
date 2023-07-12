package com.recursion;

public class Searching_element {
    public static void main(String[] args) {
        int[] arr = {9,8,6,3,8,9,4,7,2,11,10,6};
        int target = 6;
        int first_find = firstIndex(arr,target,0);
        int last_find1 = lastIndex1(arr,target,arr.length-1);
        int last_find2 = lastIndex2(arr,target,0);
//        System.out.println(first_find);
        System.out.println(last_find1);
        System.out.println(last_find2);
    }

    private static int lastIndex2(int[] arr, int target, int i) {
        if (i==arr.length) {
            return -1;
        }
        int required = lastIndex2(arr,target,i+1);
        if (required==-1) {
            if (arr[i]==target) {
                return i;
            }else return -1;
        }else return required;
    }

    private static int lastIndex1(int[] arr, int target, int i) {
        if (i<0) {
            return -1;
        }
        if (target==arr[i]) {
            return i;
        }else return lastIndex1(arr,target,i-1);
    }

    private static int firstIndex(int[] arr, int target , int i) {
        if (i== arr.length) {
            return -1;
        }
        if (target==arr[i]) {
            return i;
        }else return firstIndex(arr,target,i+1);
    }
}
