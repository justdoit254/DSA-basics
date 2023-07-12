package com.array;

public class FirstAndLastIndex {
    public static void main(String[] args) {
        int[] arr = {1,5,10,15,22,33,33,33,33,33,40,42,55,66,77};
            int start = 0;
            int end = arr.length - 1;
            int target = 33;
            int first = -1;

            while(start <= end) {
                // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
                int mid = start + (end - start) / 2;

                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;
                } else {
                    // ans found
                    first = mid;
                    end = mid - 1;
                }
            }

                 start = 0;
                 end = arr.length - 1;
                 int last = -1;

                while(start <= end) {
                    // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
                   int mid = start + (end - start) / 2;

                    if (target < arr[mid]) {
                        end = mid - 1;
                    } else if (target > arr[mid]) {
                        start = mid + 1;
                    } else {
                        // ans found
                        last = mid;
                        start = mid + 1;
                    }
                }
        System.out.println(first);
        System.out.println(last);

    }
}
