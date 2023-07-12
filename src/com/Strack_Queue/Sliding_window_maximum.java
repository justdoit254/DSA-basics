package com.Strack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Sliding_window_maximum {
    public static void main(String[] args) {
        int[] arr ={7,5,2,6,4,3,8,1,5};
//        int[] arr = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};
        int n = arr.length;
        int k = 4;              //window size
        int[] ngr = new int[n];
        Stack<Integer> stk = new Stack<>();
        // Iterate from right to left to find array containing next_smaller elements in right
        for (int i = n-1; i >=0 ; i--) {
            int num = arr[i];
            while (!stk.empty() && arr[stk.peek()]<=num){
                stk.pop();
            }
            if (stk.empty()) {
                ngr[i] = n;
            } else {
                ngr[i] = stk.peek();
            }
            stk.push(i);
        }
        System.out.println(Arrays.toString(ngr));
        int max = 0;

        for (int i = 0; i <= n-k; i++) {
//            if (max<i) {
                max = i;
//            }

            while (ngr[max]<i+k) {
                max = ngr[max];
            }
            System.out.println(arr[max]);

        }

    }
}
