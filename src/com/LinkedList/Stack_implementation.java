package com.LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class Stack_implementation {
    public static void main(String[] args) {
        LL_to_Stack stk = new LL_to_Stack();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (!str.startsWith("quit")) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                stk.push(val);
            } else if (str.startsWith("pop")) {
                int val = stk.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = stk.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(stk.size());
            }
            str = sc.nextLine();
        }
    }

    public static class LL_to_Stack{
            LinkedList<Integer> ld;
            public LL_to_Stack() {
                ld = new LinkedList<>();
            }

//            Here addFirst and removeFirst is used due to two reasons:
//            1. Time complexity of removeLast is O(n) whereas that of removeFirst is O(1)
//            2. peekLast may show NullPointException
            int size() {
                return ld.size();
            }

            void push(int val) {
                ld.addFirst(val);
            }

            int pop() {
                if (size()==0) {
                    System.out.println("Stack is empty");
                    return -1;
                }
                else return ld.removeFirst();
            }

            int top() {
                if (size()==0) {
                    System.out.println("Stack is empty");
                    return -1;
                }
                else return ld.getFirst();
            }

    }
}
