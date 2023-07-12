package com.Strack_Queue;

import java.util.Arrays;
import java.util.Stack;

public class Largest_area_histogram {
    public static void main(String[] args) {
        int[] arr = {6,2,5,4,5,1,6};
        int n = arr.length;
        int[] nse_r = new int[n];       // next_Smaller_element in right
        int[] nse_l = new int[n];       //next_smaller_element in left
        Stack<Integer> stk = new Stack<>();

        // Iterate from right to left to find array containing next_smaller elements in right
        for (int i = n-1; i >=0 ; i--) {
            int num = arr[i];
                    while (!stk.empty() && arr[stk.peek()]>=num){
                        stk.pop();
                    }
                    if (stk.empty()) {
                        nse_r[i] = n;
                    } else {
                        nse_r[i] = stk.peek();
                    }
            stk.push(i);
        }
        System.out.println(Arrays.toString(nse_r));
        // clearing the stack
        stk.clear();

        // Iterate from left to right to find array containing next_smaller elements in left
        for (int i = 0; i < n ; i++) {
            int num = arr[i];
                    while (!stk.empty() && arr[stk.peek()]>=num){
                        stk.pop();
                    }
                    if (stk.empty()) {
                        nse_l[i] = -1;
                    } else {
                        nse_l[i] = stk.peek();
                    }
            stk.push(i);
        }
        System.out.println(Arrays.toString(nse_l));

        int max_area = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int len = arr[i];
            int bre = nse_r[i]-nse_l[i]-1;
            int area = len*bre;
            if (area>max_area) {
                max_area = area;
            }
        }
        System.out.println(max_area);

    }
}
