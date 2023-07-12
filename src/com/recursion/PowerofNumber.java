package com.recursion;

public class PowerofNumber {
    public static void main(String[] args) {
        int n = 2;
        int p = 5;
        int result1 = powerLinear(n,p);
        int result2 = powerLogarithmic(n,p);
        System.out.println(result1);
        System.out.println(result2);
    }

    private static int powerLogarithmic(int n, int p) {
        if (p==0) {
            return 1;
        }
        if (p%2!=0) return n * powerLogarithmic(n,(p-1)/2) * powerLogarithmic(n,(p-1)/2);
        else return  powerLogarithmic(n,p/2) * powerLogarithmic(n,p/2);
    }

    private static int powerLinear(int n, int p) {
        if (p==0) {
            return 1;
        }
        return n * powerLinear(n,p-1);
    }
}
