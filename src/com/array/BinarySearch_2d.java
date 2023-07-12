package com.array;

public class BinarySearch_2d {
    public static void main(String[] args) {
        int[][] arr = {
                {11,12,13,14},
                {21,22,23,24},
                {31,32,33,34},
                {41,42,43,44}
        };
        int search = 42;
        int i = 0;
        int j = arr[0].length-1;
        while (i<arr.length && j>=0) {
            if (arr[i][j]==search) {
                System.out.println(i);
                System.out.println(j);
                return;
            }else if (arr[i][j]>search) {
                j--;
            }else {
                i++;
            }
        }
        System.out.println("Invalid Input");
    }
}
