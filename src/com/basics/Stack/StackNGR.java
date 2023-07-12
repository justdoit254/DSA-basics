package com.basics.Stack;

import java.util.Stack;

public class StackNGR {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        for (int i = n-1; i >=0; i--) {
            while (!s.isEmpty() && arr[i]>s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                ans[i] = -1;
            }
            else {
                ans[i] = s.peek();
            }
            s.push(arr[i]);
        }
        for (int i : ans) {
            System.out.print(i);
            System.out.print(" ");
        }

    }
}
