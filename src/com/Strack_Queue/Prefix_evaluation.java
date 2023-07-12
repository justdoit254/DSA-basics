package com.Strack_Queue;

import java.util.Stack;

public class Prefix_evaluation {
    public static void main(String[] args) {
        String str = "-+2/*6483";
        Stack<Integer> evaluation = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> postfix = new Stack<>();

        int i = str.length()-1;
        while (i>=0) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                evaluation.push(ch-'0');
                infix.push(ch+"");
                postfix.push(ch+"");
            } else if (ch=='*' || ch=='/' || ch=='+' || ch=='-') {
                int val1 = evaluation.pop();
                int val2 = evaluation.pop();
                evaluation.push(perform_operation(val1,val2,ch));

                String infix_v1 = infix.pop();
                String infix_v2 = infix.pop();
                infix.push("("+infix_v1+ch+infix_v2+")");

                String postfix_v1 = postfix.pop();
                String postfix_v2 = postfix.pop();
                postfix.push(postfix_v1+postfix_v2+ch);
            }
            i--;
        }
        System.out.println(evaluation.pop());
        System.out.println(infix.pop());
        System.out.println(postfix.pop());

    }

    private static int perform_operation(int val1, int val2, char operation) {
        int result = 0;
        if (operation=='+') {
            result = val1 + val2;
        }else if (operation=='-') {
            result = val1 - val2;
        }else if (operation=='*') {
            result = val1 * val2;
        }else if (operation=='/') {
            result = val1 / val2;
        }
        return result;
    }
}
