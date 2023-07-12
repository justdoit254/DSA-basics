package com.Strack_Queue;

import java.util.Stack;

public class Infix_expression {
    public static void main(String[] args) {
        String str = "2+(5-3*6/2)";
        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int i = 0;
        while (i<str.length()) {
            char ch = str.charAt(i);
            if (ch=='(') {
                operator.push(ch);
            } else if (ch==')') {
                while (operator.peek()!='(') {
                    int val2 = operand.pop();
                    int val1 = operand.pop();
                    int operation = operator.pop();
                    int new_val = perform_operation(val1,val2,operation);
                    operand.push(new_val);
                }
                operator.pop();
            } else if (Character.isDigit(ch)) {
                operand.push(ch-'0');
            } else if (ch=='+' || ch=='-' || ch=='*' || ch=='/') {
                while (operator.size()>0 && operator.peek()!='(' && precedence(operator.peek())>=precedence(ch)) {
                    int val2 = operand.pop();
                    int val1 = operand.pop();
                    int operation = operator.pop();
                    int new_val = perform_operation(val1,val2,operation);
                    operand.push(new_val);
                }
                operator.push(ch);
            }
            i++;
        }
        while (operator.size()>0) {
            int val2 = operand.pop();
            int val1 = operand.pop();
            int operation = operator.pop();
            int new_val = perform_operation(val1,val2,operation);
            operand.push(new_val);
        }
        System.out.println(operand.peek());
    }

    private static int perform_operation(int val1, int val2, int operation) {
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

    private static int precedence(Character operator) {
        if (operator=='+') return 1;
        if (operator=='-') return 1;
        if (operator=='*') return 2;
        if (operator=='/') return 2;
        return 0;
    }
}
