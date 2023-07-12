package com.array;

import java.util.*;

public class ArrayRotateLeft {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //size of array
        int[] arr = new int[n]; //array initialization
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
        int x = sc.nextInt();   //number of times array to be rotated in left direction
        for (int i = 0; i < x; i++) {
            int j = n-1;
            int temp = arr[j];
            for (; j >=1 ; j--) {
                int next = arr[j-1];
                arr[j-1] = temp;
                temp = next;
            }
            arr[n-1] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        int p = arr.length;

    }

}