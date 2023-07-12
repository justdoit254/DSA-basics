package com.array;

import java.util.Scanner;

public class ArrayRotateRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //size of array
        int[] arr = new int[n]; //array initialization
        for (int i = 0; i < n; i++) {
            arr[i]= sc.nextInt();
        }
        int x = sc.nextInt();   //number of times array to be rotated in left direction
        for (int i = 0; i < x%n; i++) {
            int j = 0;
            int temp = arr[j];
            for (; j <n-1 ; j++) {
                int next = arr[j+1];
                arr[j+1] = temp;
                temp = next;
            }
            arr[0] = temp;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        int p = arr.length;
    }
}
