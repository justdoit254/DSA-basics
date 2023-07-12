package com.string;

public class AllPermutationOfString {
    public static void main(String[] args) {
        String str = "abc";
        int n = str.length();
        int fact = factorial(n);
        for (int i = 0; i < fact; i++) {
            int temp = i;
            StringBuilder sb = new StringBuilder(str);
            for (int j = n; j >0 ; j--) {
                int q = temp/j;
                int r = temp%j;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp = q;
            }
            System.out.println();
        }
    }

    private static int factorial(int n) {
        int val = 1;
        for (int i = 2; i <= n; i++) {
            val *= i;
        }
        return val;
    }
}
