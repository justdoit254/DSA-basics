package com.DynamicProgramming;

import java.util.Scanner;

public class CountBinaryStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int zeros = 1;
        int ones = 1;
        for (int i = 2; i <= n; i++) {
            int nzeros = ones;
            int nones = ones + zeros;

            zeros = nzeros;
            ones = nones;
        }
        System.out.println(ones + zeros);

    }

}
