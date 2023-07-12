package com.Hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] arr2 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr2[i] = sc.nextInt();
        }

        HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            if (hm.containsKey(arr1[i])) {
//                even no need to update freq in this problem as only presence matter no freq
                int oldF = hm.get(arr1[i]);
                int newF = oldF + 1;
                hm.put(arr1[i],newF);
            } else {
                hm.put(arr1[i],1);
            }
        }
//        Get Common Element 1
//        for (int i = 0; i < n2; i++) {
//            if (hm.containsKey(arr2[i])) {
//                System.out.println(arr2[i]);
//                hm.remove(arr2[i]);
//            }
//        }
//        Get Common Element 2
        for (int i = 0; i < n2; i++) {
            int val = arr2[i];
            if (hm.containsKey(val)) {
                int oldF = hm.get(val);
                if (oldF>0) System.out.println(val);
                int newF = oldF -1;
                hm.put(val,newF);
            }

        }
    }
}
