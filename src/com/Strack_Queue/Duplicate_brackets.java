package com.Strack_Queue;

import java.util.Stack;

public class Duplicate_brackets {
    public static void main(String[] args) {
        String str = "((a+b)+(c+d))";
        Stack<Character> stk = new Stack<>();
        int i = 0;
        while (i<str.length()) {
            char ch = str.charAt(i);
            if (ch==')') {
                if (stk.peek()=='(') {
                    System.out.println(true);
                    return;
                } else {
                    while (stk.peek()!='(') {
                        stk.pop();
                    }
                    stk.pop();
                }
            } else {
                stk.push(ch);
            }
            i++;
        }
        System.out.println("false");
    }
}
