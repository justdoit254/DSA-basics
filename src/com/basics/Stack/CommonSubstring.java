package com.basics.Stack;

public class CommonSubstring {
    public static void main(String[] args) {
        String S1 = "ABCDGH";
        String S2 = "ACDGHF";
        int n = S1.length();
        int m = S2.length();
        int q = 0;
        String [] a1 = new String[n*(n+1)/2];
        String[] a2 = new String[m*(m+1)/2];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <= n ; j++) {
                a1[i] = S1.substring(i,j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j <= m ; j++) {
                a2[i] = S2.substring(i,j);
            }
        }
        for (String s : a1) {
            for (String str : a2) {
                int p = s.length();
                if (s==str && p>q) {
                    q = p;
                }
            }
        }
        System.out.println(q);
    }
}
