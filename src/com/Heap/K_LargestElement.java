package com.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class K_LargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }
        for (int i = k; i < n; i++) {
            int val = pq.peek();
            if (val<arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        while (pq.size()>0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
//    12 62 22 15 37 99 11 37 98 67 31 84 99

}
