package com.Strack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Min_of_stack2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
       MinStack st = new MinStack();
        while (!str.equals("quit")) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(String.valueOf(str.split(" ")[1]));
                st.push(val);

            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val!=-1) System.out.println(val);

            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val!=-1) System.out.println(val);

            } else if (str.startsWith("size")) {
                System.out.println(st.size());

            } else if (str.startsWith("min")) {
                System.out.println(st.min());
            }
            str = sc.nextLine();
        }

    }
    public  static class MinStack{
        Stack<Integer> data;
        int min;


        public MinStack() {
            data = new Stack<>();
        }

        void push(int val) {
            if (data.empty()) {
                data.push(val);
                min = val;
            } else if (val<min){
                data.push(val+(val-min));
                min = val;
            } else data.push(val);
        }

        int pop() {
            if (data.empty()) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                if (data.peek()<min) {
                    int original_val = min;
                    min = 2*min-data.pop();
                    return original_val;
                } else return data.pop();
            }
        }

        int top() {
            if (data.empty()) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                if (data.peek()<min) {
                    return min;
                } else return data.pop();
            }
        }

        int size() {
            return data.size();
        }

        int min() {
            if (size()==0) {
                System.out.println("Stack Underflow");
                return -1;
            } else return min;
        }


    }
}
