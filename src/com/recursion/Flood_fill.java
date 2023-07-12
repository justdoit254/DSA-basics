package com.recursion;

public class Flood_fill {
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] arr = {
                {0,1,0,0,0,0,0},
                {0,1,0,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,0,1,1,0,1,1},
                {1,0,1,1,0,1,1},
                {1,0,0,0,0,0,0}
        };
        boolean[][] check = new boolean[n][m];
        flood_fill(arr,0,0,"",check);
    }

    private static void flood_fill(int[][] arr, int sr, int sc, String ans, boolean[][] check) {
        if (sr<0 || sc<0 || sr== arr.length || sc== arr[0].length || arr[sr][sc]==1 || check[sr][sc]) {
            return;
        }
        if (sr== arr.length-1 && sc==arr[0].length-1) {
            System.out.println(ans);
            return;
        }
        check[sr][sc] = true;
        flood_fill(arr,sr-1,sc,ans+"t",check);
        flood_fill(arr,sr,sc-1,ans+"l",check);
        flood_fill(arr,sr+1,sc,ans+"d",check);
        flood_fill(arr,sr,sc+1,ans+"r",check);
        check[sr][sc] = false;
    }
}
