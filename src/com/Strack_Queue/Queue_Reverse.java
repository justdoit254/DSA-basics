package com.Strack_Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Queue_Reverse {
    public static void main(String[] args) {
        Queue<Integer> qu = new ArrayDeque<Integer>();
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        System.out.println(qu);
        System.out.println(qu.peek());

//        Method 1
//          Stack<Integer> s = new Stack<>();
//        while (!qu.isEmpty()) {
//            s.push(qu.remove());
//        }
//        while (!s.isEmpty()) {
//            qu.add(s.pop());
//        }
//        Method 2
        reverse(qu);

        System.out.println(qu);
        System.out.println(qu.peek());
    }
    private static void reverse(Queue<Integer> qu) {
        if (qu.isEmpty()) {
            return;
        }
        int el = qu.remove();
        reverse(qu);
        qu.add(el);
    }
}
