package com.basics.Stack;

import java.util.ArrayList;

public class PalindromePartition {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        String s = "geeks";
        int n = s.length();
        int count = 1;
        int m = n;
        while (count<=n) {
            m = n-count+1;
            for (int i = 0; i < m; i++) {
                String z = s.substring(i,i+count);
                boolean b = true;
                int p=0;
                while (b && p<z.length()/2) {
                    if (z.charAt(p)==z.charAt(z.length()-1-p)) {
                        p++;
                    }
                    else {
                        b = false;
                    }
                }
                if (b) {
                    System.out.print(z);
                    System.out.print("  ");
                }
                else {
                    System.out.print(z.charAt(0));
                    System.out.print("  ");
                }

            }
            System.out.println();
            //m--;
            count++;
        }
    }
}
