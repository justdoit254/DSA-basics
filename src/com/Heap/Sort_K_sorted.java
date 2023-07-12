package com.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Sort_K_sorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int[] ans = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k+1; i < n; i++) {
            int val = pq.peek();
            System.out.println(val);
            pq.remove();
            pq.add(arr[i]);
        }
        while (pq.size()>0) {
            System.out.println(pq.peek());
            pq.remove();
        }
    }
//    3 2 4 1 6 5 7 9 8
}
