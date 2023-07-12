package com.array;

import java.util.Scanner;

public class SpanofArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10,5,4,19,3,8};
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) max = arr[i];   //to get maximum value
            if (arr[i]<min) min = arr[i];   //to get minimum value
        }
        ans = max-min;
        System.out.println(ans);

    }
}
