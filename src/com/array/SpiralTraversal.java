package com.array;

public class SpiralTraversal {
    public static void main(String[] args) {
//        int[][] arr = {
//                {11,12,13,14,15,16,17},
//                {21,22,23,24,25,26,27},
//                {31,32,33,34,35,36,37},
//                {41,42,43,44,45,46,47},
//                {51,52,53,54,55,56,57}
//        };
        int[][] arr = {
                {11,12,13},
                {21,22,23},
                {31,32,33}

        };
        int minr = 0;
        int minc = 0;
        int maxr = arr.length-1;
        int maxc = arr[0].length-1;
        int totalElement = arr.length * arr[0].length;
        int count = 0;
        while (count < totalElement) {
            //left wall
            for (int i = minr,j=minc; i <= maxr && count < totalElement ; i++) {
                System.out.println(arr[i][j]);
                count++;
            }
            minc++;
            //bottom wall
            for (int i = maxr,j=minc; j <= maxc && count < totalElement ; j++) {
                System.out.println(arr[i][j]);
                count++;
            }
            maxr--;
            //right wall
            for (int i = maxr,j=maxc; i >=minr && count < totalElement ; i--) {
                System.out.println(arr[i][j]);
                count++;
            }
            maxc--;
            //top wall
            for (int i = minr,j=maxc; j >= minc && count < totalElement; j--) {
                System.out.println(arr[i][j]);
                count++;
            }
            minr++;
        }
    }
}
