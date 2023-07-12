package com.Strack_Queue;

import java.util.Stack;

public class Smallest_number_following_pattern {
    public static void main(String[] args) {
        String str = "ddiddidd";
        Stack<Integer> stk = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            stk.push(count);
            if (str.charAt(i)=='i'){
                while (stk.size()>0) {
                    System.out.print(stk.pop());
                }
            }
        }
        count++;
        stk.push(count);
        while (stk.size()>0) {
            System.out.print(stk.pop());
        }
    }
}
