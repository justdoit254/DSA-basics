package com.array;


public class CeilAndFloor {
    public static void main(String[] args) {
       int[] arr = {10,20,30,40,50,60,70};
       int d = 55;
       // First Way with functions
       int ceil = binarySearchCeil(arr,d);
       int floor = binarySearchFloor(arr,d);
        System.out.println(ceil);
        System.out.println(floor);
        // Second Way
        int Ceil = 0;
        int Floor = 0;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (d < arr[mid]) {
                end = mid - 1;
                Ceil = arr[mid];
            } else if (d > arr[mid]) {
                start = mid + 1;
                Floor = arr[mid];
            } else {
                // ans found
                Ceil = arr[mid];
                Floor = arr[mid];
            }
        }
        System.out.println(Ceil);
        System.out.println(Floor);
    }
    static int binarySearchCeil(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return arr[start];
    }static int binarySearchFloor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        return arr[end];
    }
}
