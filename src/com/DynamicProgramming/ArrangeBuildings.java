package com.DynamicProgramming;

import java.util.Scanner;

public class ArrangeBuildings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int buildings = 1;
        int spaces = 1;
        for (int i = 2; i <= n; i++) {
            int nSpaces = spaces;
            int nBuildings = spaces + buildings;

            buildings = nSpaces;
            spaces = nBuildings;
        }
        System.out.println((spaces + buildings)* (spaces + buildings));
    }
}
