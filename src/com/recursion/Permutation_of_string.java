package com.recursion;

public class Permutation_of_string {
    public static void main(String[] args) {
        String str = "abc";
        print_permutation(str,"");
    }

    private static void print_permutation(String str, String ans) {
        if (str.length()==0) {
            System.out.println(ans);
            return;
        }
//        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String new_Str = str.substring(0,i) + str.substring(i+1);

//            sb = sb.deleteCharAt(i);
            print_permutation(new_Str.toString(), ans+ch);
        }
//        char ch = str.charAt(0);
//        String new_str = str.substring(1);
//        print_permutation(new_str,ans+ch);

    }
}
