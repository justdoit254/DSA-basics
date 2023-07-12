package com.array;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] arr1 = {
                {3,2,1,5},
                {9,1,3,0}
        };
        int[][] arr2 = {
                {2,9,0},
                {1,3,5},
                {2,4,7},
                {8,1,5}
        };
        if (arr1[0].length != arr2.length) System.out.println("Invalid input");
        int[][] prod = new int[arr1.length][arr2[0].length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                for (int k = 0; k < arr2.length; k++) {
                    prod[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        for (int i = 0; i < prod.length; i++) {
            System.out.print(Arrays.toString(prod[i]));
            System.out.println();
        }
    }

}
