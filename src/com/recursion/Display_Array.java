package com.recursion;

public class Display_Array {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};
        int n = 0;
        displayarray(arr,n);
        displayreversearray(arr,n);
    }

    private static void displayreversearray(int[] arr, int n) {
        if (n== arr.length) return;
        displayreversearray(arr,n+1);
        System.out.println(arr[n]);
    }

    private static void displayarray(int[] arr, int n) {
        if (n== arr.length) return;
        System.out.println(arr[n]);
        displayarray(arr,n+1);
    }
}
