package com.Strack_Queue;

import java.util.Stack;

public class Postfix_evaluation {
    public static void main(String[] args) {
        String str = "264*8/+3-";
        Stack<Integer> evaluation = new Stack<>();
        Stack<String> infix = new Stack<>();
        Stack<String> prefix = new Stack<>();

        int i = 0;
        while (i<str.length()) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                evaluation.push(ch-'0');
                infix.push(ch+"");
                prefix.push(ch+"");
            } else if (ch=='*' || ch=='/' || ch=='+' || ch=='-') {
                int val2 = evaluation.pop();
                int val1 = evaluation.pop();
                evaluation.push(perform_operation(val1,val2,ch));

                String infix_v2 = infix.pop();
                String infix_v1 = infix.pop();
                infix.push("("+infix_v1+ch+infix_v2+")");

                String prefix_v2 = prefix.pop();
                String prefix_v1 = prefix.pop();
                prefix.push(ch+prefix_v1+prefix_v2);
            }
            i++;
        }
        System.out.println(evaluation.pop());
        System.out.println(infix.pop());
        System.out.println(prefix.pop());

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
