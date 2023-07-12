package com.array;

public class StateOfWakanda_2 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16},

        };
        for (int g = 0; g < arr.length; g++) {
            for (int i = 0, j=g; j<arr.length ; i++,j++) {
                System.out.println(arr[i][j]);

            }
        }
    }
}
