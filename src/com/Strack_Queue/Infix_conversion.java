package com.Strack_Queue;

import java.util.Stack;

public class Infix_conversion {
    public static void main(String[] args) {
        String str = "a*(b-c+d)/e";
        Stack<String> postfix = new Stack<>();
        Stack<String> prefix = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int i = 0;
        while (i<str.length()) {
            char ch = str.charAt(i);
            if (ch=='(') {
                operator.push(ch);
            } else if (ch==')') {
                while (operator.peek()!='(') {
                    Character operation = operator.pop();

                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    postfix.push(postval1+postval2+operation);

                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    prefix.push(operation+preval1+preval2);
                }
                operator.pop();
            } else if ((ch>='a' && ch<='z') || (ch>='0' && ch<='9') || (ch>='A' && ch<='Z')) {
                postfix.push(ch+"");
                prefix.push(ch+"");
            } else if (ch=='+' || ch=='-' || ch=='*' || ch=='/') {
                while (operator.size()>0 && operator.peek()!='(' && precedence(operator.peek())>=precedence(ch)) {
                    Character operation = operator.pop();

                    String postval2 = postfix.pop();
                    String postval1 = postfix.pop();
                    postfix.push(postval1+postval2+operation);

                    String preval2 = prefix.pop();
                    String preval1 = prefix.pop();
                    prefix.push(operation+preval1+preval2);
                }
                operator.push(ch);
            }
            i++;
        }
        while (operator.size()>0) {
            Character operation = operator.pop();

            String postval2 = postfix.pop();
            String postval1 = postfix.pop();
            postfix.push(postval1+postval2+operation);

            String preval2 = prefix.pop();
            String preval1 = prefix.pop();
            prefix.push(operation+preval1+preval2);
        }
        System.out.println(postfix);
        System.out.println(prefix);
    }


    private static int precedence(Character operator) {
        if (operator=='+') return 1;
        if (operator=='-') return 1;
        if (operator=='*') return 2;
        if (operator=='/') return 2;
        return 0;
    }

}
