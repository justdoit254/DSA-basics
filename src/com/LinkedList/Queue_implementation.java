package com.LinkedList;

import java.util.LinkedList;
import java.util.Scanner;

public class Queue_implementation {
    public static void main(String[] args) {
        LL_to_Queue que = new LL_to_Queue();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (!str.startsWith("quit")) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                que.add(val);
            } else if (str.startsWith("remove")) {
                int val = que.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = que.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(que.size());
            }
            str = sc.nextLine();
        }
    }

    public static class LL_to_Queue{
        LinkedList<Integer> ld;
        public LL_to_Queue() {
            ld = new LinkedList<>();
        }

        //            Here addLast and removeFirst is used because:
//            1. Time complexity of removeLast is O(n) whereas that of removeFirst is O(1)
        int size() {
            return ld.size();
        }

        void add(int val) {
            ld.addLast(val);
        }

        int remove() {
            if (size()==0) {
                System.out.println("Queue is empty");
                return -1;
            }
            else return ld.removeFirst();
        }

        int peek() {
            if (size()==0) {
                System.out.println("Queue is empty");
                return -1;
            }
            else return ld.getFirst();
        }

    }
}
