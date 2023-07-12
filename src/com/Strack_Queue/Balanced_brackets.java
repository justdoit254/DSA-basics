package com.Strack_Queue;

import java.util.Stack;

public class Balanced_brackets {
    public static void main(String[] args) {
        String str = "[(a+b)+{(c+d)*(e/f)}]";
        Stack<Character> stk = new Stack<>();
        int i = 0;
        while (i<str.length()) {
            char ch = str.charAt(i);
            if (ch=='(' || ch=='[' || ch=='{') {
                stk.push(ch);
            } else if (ch==')' || ch==']' || ch=='}') {
                if (ch==')') {
                    if (!stk.empty() && stk.peek()=='(') {
                        stk.pop();
                    } else {
                        System.out.println(false);
                        return;
                    }
                }if (ch==']') {
                    if (!stk.empty() && stk.peek()=='[') {
                        stk.pop();
                    } else {
                        System.out.println(false);
                        return;
                    }
                }if (ch=='}') {
                    if (!stk.empty() && stk.peek()=='{') {
                        stk.pop();
                    } else {
                        System.out.println(false);
                        return;
                    }
                }
            }
            i++;
        }
        System.out.println(stk.empty());

    }
}
