package com.recursion;

public class N_queens {
    public static void main(String[] args) {
        int n = 4;
        int[][] chess = new int[n][n];
        queens_position(chess,"",0);
    }

    private static void queens_position(int[][] chess, String ans, int row) {
        if (row == chess.length) {
            System.out.println(ans);
            return;
        }
        for (int col = 0; col < chess[0].length; col++) {
            if (chess[row][col]==0 && queen_is_safe(chess,row,col)) {
                chess[row][col] = 1;
                queens_position(chess, ans + row + "-" + col + ",", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    private static boolean queen_is_safe(int[][] chess, int row, int col) {
        for (int r = row - 1, c = col; r >= 0; r--) {
            if (chess[r][c] == 1) return false;
        }
        for (int r = row , c = col; r >= 0 && c >= 0; r--, c--) {
            if (chess[r][c]==1) return false;
        }
        for (int r = row, c = col; r>=0 && c<=chess[0].length-1; r--, c++) {
            if (chess[r][c]==1) return false;
        }
        return true;
    }
}
