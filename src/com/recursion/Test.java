package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        for (int i = 0; i < test_cases; i++) {
            int n = sc.nextInt();
            long[] arr = new long[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
             isBeautiful(arr);
//            System.out.println(b);
        }

    }

    private static void isBeautiful(long[] arr) {
        long gcdA = arr[0];
        long gcdB = arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (i%2==0) gcdA = gcdbyEuclideanAlgorithm(gcdA,arr[i]);    //even index
            else gcdB = gcdbyEuclideanAlgorithm(gcdB,arr[i]);   //odd index
        }
        boolean bol =true ;
        for (int i = 2; i < arr.length; i+=2) {
            if (arr[i]%gcdB==0) {
                bol =false ;
                break;
            }
        }
        if (bol) {
            System.out.println(gcdB);


        }
         bol =true ;
        for (int i = 3; i < arr.length; i+=2) {
            if (arr[i]%gcdA==0) {
                bol =false ;
                break;
            }
        }
        if (bol) {
            System.out.println(gcdA);


        }
        if (!bol)         System.out.println(0);


    }

    private static long gcdbyEuclideanAlgorithm(long n1, long n2) {
        if (n2==0) {
            return n1;
        }
        return gcdbyEuclideanAlgorithm(n2,n1%n2);
    }


}
