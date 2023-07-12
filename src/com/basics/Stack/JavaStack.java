package com.basics.Stack;

import java.util.Scanner;
import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while (sc.hasNext()) {
            s = sc.next();
            System.out.println(check(s));
        }
    }
    public static boolean check(String s) {
        int n = s.length();
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c=='[' || c=='{' || c=='(') {
                stk.push(c);
            }
            else if (c==']') {
                if (stk.isEmpty() || stk.pop() != '[') {
                    return false;
                }
            }
            else if (c=='}') {
                if (stk.isEmpty() || stk.pop() != '{') {
                    return false;
                }
            }else if (c==')') {
                if (stk.isEmpty() || stk.pop() != '(') {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }
}
