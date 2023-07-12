package com.Hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        HashMap<Integer,Boolean> hm = new HashMap<>();
        for (int val : arr) {
            hm.put(val,true);
        }
        for (int val : arr) {
            if (hm.containsKey(val-1)) {
                hm.put(val,false);
            }
        }
        int ml = 0;
        int mse = 0;
        for (int val : arr) {
            if(hm.containsKey(val)) {
                int tl = 1;
                int tsp = val;
                while (hm.containsKey(tsp+tl)) {
                    tl++;
                }
                if (tl>ml) {
                    ml = tl;
                    mse = tsp;
                }
            }

        }
        for (int i = 0; i < ml; i++) {
            System.out.println(mse+i);
        }
//        12 5 1 2 10 2 13 7 11 8 9 11 8 9 5 6 11

    }
}
