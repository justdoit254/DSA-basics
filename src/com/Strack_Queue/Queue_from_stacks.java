package com.Strack_Queue;

import java.util.Scanner;
import java.util.Stack;

public class Queue_from_stacks {
    public static void main(String[] args) {
//        Stack_to_queue_addefficient stq = new Stack_to_queue_addefficient();
        Stack_to_queue_removeefficient stq = new Stack_to_queue_removeefficient();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (!str.equals("quit")) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(String.valueOf(str.split(" ")[1]));
                stq.add(val);

            } else if (str.startsWith("remove")) {
                int val = stq.remove();
                if (val!=-1) System.out.println(val);

            } else if (str.startsWith("peek")) {
                int val = stq.peek();
                if (val!=-1) System.out.println(val);

            } else if (str.startsWith("size")) {
                System.out.println(stq.size());

            }
            str = sc.nextLine();
        }
    }

    public static class Stack_to_queue_addefficient{
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public Stack_to_queue_addefficient() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            mainS.push(val);
        }

        int peek() {
            if (mainS.empty()) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                while (mainS.size()>1) {
                    helperS.push(mainS.pop());
                }
                int el = mainS.pop();
                helperS.push(el);
                while (helperS.empty()){
                    mainS.push(helperS.pop());
                }
                return el;
            }
        }

        int remove() {
            if (mainS.empty()) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                while (mainS.size()>1) {
                    helperS.push(mainS.pop());
                }
                int el = mainS.pop();
                while (helperS.empty()){
                    mainS.push(helperS.pop());
                }
                return el;
            }
        }
    }

    public static class Stack_to_queue_removeefficient{
        Stack<Integer> mainS;
        Stack<Integer> helperS;

        public Stack_to_queue_removeefficient() {
            mainS = new Stack<>();
            helperS = new Stack<>();
        }

        int size() {
            return mainS.size();
        }

        void add(int val) {
            while (mainS.empty()) {
                helperS.push(mainS.pop());
            }
            mainS.push(val);
            while (helperS.empty()) {
                mainS.push(helperS.pop());
            }
        }

        int peek() {
            if (mainS.empty()) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return mainS.peek();
            }
        }

        int remove() {
            if (mainS.empty()) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return mainS.pop();
            }
        }
    }
}
