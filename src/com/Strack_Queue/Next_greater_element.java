package com.Strack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Next_greater_element {
    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};
        int n = arr.length;
        int[] ans = new int[n];
        //Brute-force approach
//        ans[n-1] = -1;
//        for (int i = 0; i < n-1; i++) {
//            for (int j = i+1; j < n; j++) {
//                if (arr[j]>arr[i]) {
//                    ans[i] = arr[j];
//                    break;
//                } else ans[i] = -1;
//
//            }
//        }

        //Optimised approach
        Stack<Integer> stk = new Stack<>();
        // (Iterate from right to left)
//        for (int i = n-1; i >=0 ; i--) {
//            int num = arr[i];
//
//                    while (!stk.empty() && stk.peek()<=num){
//                        stk.pop();
//                    }
//                    if (stk.empty()) {
//                        ans[i] = -1;
//                    } else {
//                        ans[i] = stk.peek();
//                    }
//            stk.push(num);
//        }
//        System.out.println(Arrays.toString(ans));

        // Iterate from left to right
        stk.push(0);
        for (int i = 1; i<n; i++) {
            while (stk.size()>0 && arr[i]>arr[stk.peek()]) {
                int pos = stk.peek();
                arr[pos] = arr[i];
                stk.pop();
            }
            stk.push(i);
        }
        while (stk.size()>0) {
            int pos = stk.peek();
            arr[pos] = -1;
            stk.pop();
        }
        System.out.println(Arrays.toString(arr));
    }
}
