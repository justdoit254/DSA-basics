package com.array;

public class StateOfWakanda {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        for (int i = 0; i < arr[0].length; i++) {
            if (i%2==0) {
                for (int j = 0; j < arr.length; j++) {
                    System.out.println(arr[j][i]);
                }
            }
            else {
                for (int j = arr.length-1; j >= 0; j--) {
                    System.out.println(arr[j][i]);
                }
            }
        }
    }
}
