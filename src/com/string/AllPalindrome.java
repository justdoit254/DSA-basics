package com.string;

public class AllPalindrome {
    public static void main(String[] args) {
        String str = "abccba";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i+1; j <=str.length() ; j++) {
                String str_test = str.substring(i,j);
                if (isPalindrome(str_test)) {
                    System.out.println(str_test);
                }
            }
        }
    }
    public static boolean isPalindrome(String str_test) {
        int i = 0;
        int j = str_test.length()-1;
        while (i<=j) {
            if (str_test.charAt(i)!=str_test.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
