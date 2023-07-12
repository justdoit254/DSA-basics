package com.Strack_Queue;

import java.util.Scanner;

public class Two_stack_one_array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TwoStack ts = new TwoStack(n);
        String str = sc.nextLine();
        while (!str.equals("quit")) {
            if (str.startsWith("push1")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                ts.push1(val);
            } else if (str.startsWith("pop1")) {
                int val = ts.pop1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top1")) {
                int val = ts.top1();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size1")) {
                System.out.println(ts.size1());
            } else if (str.startsWith("push2")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                ts.push2(val);
            } else if (str.startsWith("pop2")) {
                int val = ts.pop2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top2")) {
                int val = ts.top2();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size2")) {
                System.out.println(ts.size2());
            }
            str = sc.nextLine();
        }


    }

    public static class TwoStack {
        int[] data;
        int idx1;
        int idx2;

        public TwoStack(int len) {
            // write your code here
            data = new int[len];
            idx1 = -1;
            idx2 = len;
        }

        int size1() {
            return idx1 + 1;
        }

        int size2() {
            return data.length- idx2;
        }

        void push1(int val) {
            if (idx1 == idx2 +1) {
                System.out.println("Stack Overflow");
            } else {
                idx1++;
                data[idx1] = val;
            }
        }

        void push2(int val) {
            if (idx1 +1== idx2) {
                System.out.println("Stack Overflow");
            } else {
                idx2--;
                data[idx2] = val;
            }
        }

        int pop1() {
            if (idx1<0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data[idx1];
                idx1--;
                return val;
            }
        }

        int pop2() {
            if (idx2>=data.length) {        //or if(size2()==0)
                System.out.println("Stack Underflow");
                return -1;
            } else {
                int val = data[idx2];
                idx2++;
                return val;
            }
        }

        int top1() {
            if (idx1<0) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return data[idx1];
            }
        }

        int top2() {
            if (idx2>=data.length) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return data[idx2];
            }
        }
    }
}
