package com.Strack_Queue;


import java.util.Scanner;

public class Stack_implementation {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        CustomStack st = new CustomStack(n);
        while (!str.equals("quit")) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(String.valueOf(str.split(" ")[1]));
                st.push(val);
                //Dynamic Stack
                // st.push2(val);

            } else if (str.startsWith("pop")) {
                int val = st.pop();
               if (val!=-1) System.out.println(val);

            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val!=-1) System.out.println(val);

            } else if (str.startsWith("size")) {
                System.out.println(st.size());

            } else if (str.startsWith("display")) {
                st.display();

            }
            str = sc.nextLine();
        }

    }
    public  static class CustomStack{
        int[] data;
        int idx;

        public CustomStack(int len) {
            data = new int[len];
            idx = -1;
        }

        //Normal Stack
        void push(int val) {
            if (idx== data.length-1) {
                System.out.println("Stack Overflow");
            } else {
                idx++;
                data[idx] = val;
            }
        }

        //Dynamic Stack
        void push2(int val) {
            if (idx== data.length-1) {
                int[] ndata = new int[2*data.length];
                System.arraycopy(data, 0, ndata, 0, data.length);
                data = ndata;
            }
            idx++;
            data[idx] = val;
        }

        int pop() {
            if (idx<0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val =  data[idx];
                idx--;
                return val;
            }
        }

        int top() {
            if (idx<0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return data[idx];
            }
        }

        int size() {
             return idx+1;
        }

        void display() {
            for (int i = idx; i >=0 ; i--) {
                System.out.println(data[i]+" ");
            }
            System.out.println();
        }

    }
}
