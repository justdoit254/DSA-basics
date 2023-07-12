package com.basics.Stack;

import java.util.Stack;

public class Evaluationofexpression {
    public static int evaluate(String S) {
        Stack<Integer> values = new Stack<>();
        // Stack<Character> ops = new Stack<>();
        char[] tokens = S.toCharArray();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i]== ' ') continue;
            if (tokens[i]>='0' && tokens[i]<='9') {
                StringBuilder sbfr = new StringBuilder();
                // while (i< tokens.length && tokens[i]>='0' && tokens[i]<='9' )
                //sbfr.append(tokens[i++]);*/
                //values.push(Integer.parseInt(sbfr.toString()));
                sbfr.append(tokens[i]);
                values.push(Integer.parseInt(sbfr.toString()));
            }
            //else if (tokens[i]=='(') ops.push(tokens[i]);
            else if (tokens[i]=='+' || tokens[i]=='-' || tokens[i]=='*' || tokens[i]=='/') {
                //while (!ops.isEmpty() && hasprecedence(tokens[i] , ops.peek()))
                values.push(applyop(tokens[i], values.pop(), values.pop()));
                // ops.push(tokens[i]);
            }
            /*else if (tokens[i]==')') {
                while (ops.peek()!='(')
                    values.push(applyop(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }*/

        }
       /* while (!ops.empty())
            values.push(applyop(ops.pop(), values.pop(), values.pop()));*/

        // Top of 'values' contains result, return it
        return values.pop();

    }
    public static boolean hasprecedence(char o1 , char o2) {
        if (o2=='(' || o2==')') return false;
        else if ((o1=='*' || o1=='/') && (o2=='+' || o2=='-')) return false;
        else return true;
    }
    public static int applyop(char op, int b, int a) {
        switch (op) {
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if (b==0)
                    throw new
                            UnsupportedOperationException("Cannot divide by zero");
                return a/b;
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(Evaluationofexpression.evaluate("231*+9-"));
    }
}
