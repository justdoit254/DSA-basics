package com.Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianPriorityQueue {
    public static class medianPriorityQueue {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public medianPriorityQueue() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }

        public void add(int val) {
            if (right.size() > 0 && val > right.peek()) {
                right.add(val);
            } else {
                left.add(val);
            }

            if (left.size() - right.size() == 2) {
                right.add(left.remove());
            }
            if (right.size() - left.size() == 2) {
                left.add(right.remove());
            }
        }

        public int remove() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if (left.size() >= right.size()) {
                return left.remove();
            } else {
                return right.remove();
            }
        }

        public int peek() {
            if (this.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        public int size() {
            return left.size() + right.size();
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        medianPriorityQueue qu = new medianPriorityQueue();

        String str = sc.nextLine();
        while (!str.equals("quit")) {
            if (str.startsWith("add")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
            } else if (str.startsWith("remove")) {
                int val = qu.remove();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("peek")) {
                int val = qu.peek();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(qu.size());
            }
             str = sc.nextLine();

        }

    }


}
