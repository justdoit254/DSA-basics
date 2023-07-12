package com.Strack_Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Stack_from_queues {
    public static void main(String[] args) {
//        Queue_to_stack_pushefficient qts = new Queue_to_stack_pushefficient();
        Queue_to_stack_popefficient qts = new Queue_to_stack_popefficient();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (!str.equals("quit")) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(String.valueOf(str.split(" ")[1]));
                qts.push(val);

            } else if (str.startsWith("pop")) {
                int val = qts.pop();
                if (val!=-1) System.out.println(val);

            } else if (str.startsWith("top")) {
                int val = qts.top();
                if (val!=-1) System.out.println(val);

            } else if (str.startsWith("size")) {
                System.out.println(qts.size());

            }
            str = sc.nextLine();
        }


    }

    public static class Queue_to_stack_pushefficient {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public Queue_to_stack_pushefficient() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
            mainQ.add(val);
        }

        int top() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            } else {

                while (mainQ.size()>1) {
                    helperQ.add(mainQ.remove());
                }
                int el = mainQ.remove();
                helperQ.add(el);
                while (helperQ.size()>0) {
                    mainQ.add(helperQ.remove());
                }
                return el;
            }
        }

        int pop() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                while (mainQ.size()>1) {
                    helperQ.add(mainQ.remove());
                }
                int el = mainQ.remove();
                while (helperQ.size()>0) {
                    mainQ.add(helperQ.remove());
                }
                return el;
            }
        }

    }

    public static class Queue_to_stack_popefficient {
        Queue<Integer> mainQ;
        Queue<Integer> helperQ;

        public Queue_to_stack_popefficient() {
            mainQ = new ArrayDeque<>();
            helperQ = new ArrayDeque<>();
        }

        int size() {
            return mainQ.size();
        }

        void push(int val) {
                while (!mainQ.isEmpty()) {
                    helperQ.add(mainQ.remove());
                }
                mainQ.add(val);
                while (helperQ.size()>0) {
                    mainQ.add(helperQ.remove());
                }
        }

        int top() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return mainQ.peek();
            }
        }

        int pop() {
            if (mainQ.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            } else {
                return mainQ.remove();
            }
        }

    }
}
