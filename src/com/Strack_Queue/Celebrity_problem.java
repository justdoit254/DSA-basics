package com.Strack_Queue;

import java.util.Stack;

public class Celebrity_problem {        //Two pointer and recursion approach may also work
    public static void main(String[] args) {
        int[][] arr = {
            {0,0,0,0},
            {1,0,1,1},
            {1,1,0,1},
            {1,1,1,0}
        };
        Stack<Integer> stk = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            stk.push(i);
        }
        while (stk.size()>1) {
            int i = stk.pop();
            int j = stk.pop();
            if (arr[i][j]==0) {
                stk.push(i);
            } else if (arr[j][i]==0) {
                stk.push(j);
            }
        }
        if (stk.empty()) {
            System.out.println("none");
            return;
        } else {
           int idx = stk.pop();
            for (int i = 0; i < n; i++) {
                    if (i!=idx && arr[idx][i]!=0&&arr[i][idx]!=1) {
                        System.out.println("none");
                        return;
                    }
            }
            System.out.println(idx);
        }
    }
}
