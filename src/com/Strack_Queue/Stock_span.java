package com.Strack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Stock_span {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1,2,1,3,5};
        int n = arr.length;
        int[] span = new int[n];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        span[0] = 1;
        for (int i = 1; i < n; i++) {
            while (stk.size()>0 && arr[i]>=arr[stk.peek()]) {
                stk.pop();
            }
            if (stk.size()>0) {
                span[i] = i-stk.peek();
            } else {
                span[i] = i+1;
            }
            stk.push(i);

        }
        System.out.println(Arrays.toString(span));
    }
}
