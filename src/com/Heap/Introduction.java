package com.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class Introduction {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        To print in reverse order i.e. decreasing order
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = {1, 22, 18, 9, 64, 41, 24};
        for (int val : arr) {
            pq.add(val);
        }
        while (pq.size()>0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
}
