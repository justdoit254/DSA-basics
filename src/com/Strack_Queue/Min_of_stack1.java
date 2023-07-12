package com.Strack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Min_of_stack1 {
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
        Stack<Integer> minData;


        public MinStack() {
            data = new Stack<>();
            minData = new Stack<>();
        }

        //Normal Stack
        void push(int val) {
            data.push(val);
            if (minData.empty() || minData.peek()>=val) {
                minData.push(val);
            }
        }

        int pop() {
            if (data.empty()) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val =  data.pop();
                if (val==minData.peek()) {
                    minData.pop();
                }
                return val;
            }
        }

        int top() {
            if (data.empty()) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return data.peek();
            }
        }

        int size() {
            return data.size();
        }

        int min() {
            if (minData.empty()) {
                System.out.println("Stack Overflow");
                return -1;
            } else {
                return minData.peek();
            }
        }



    }
}
