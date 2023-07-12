package com.recursion;

import java.util.ArrayList;

public class Subsequence {
    public static void main(String[] args) {
        String str = "abc";
//        System.out.println(get_subsequence(str));
        print_subsequence(str,"");
    }

    private static void print_subsequence(String ques, String ans) {
        if (ques.length()==0) {
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String rest_ques = ques.substring(1);
        print_subsequence(rest_ques,ans+ch);
        print_subsequence(rest_ques,ans+"");
    }

    private static ArrayList get_subsequence(String str) {
        if (str.length()==0) {
            ArrayList<String> one = new ArrayList<>();
            one.add("");
            return one;
        }
        char c = str.charAt(0);
        String sub = str.substring(1);
        ArrayList<String> basic = get_subsequence(sub);
        ArrayList<String> result = new ArrayList<>();
//        System.out.println(basic);
//        System.out.println(result);
        for (String val : basic) {
            result.add("" + val);
        }for (String val : basic) {
            result.add(c + val);
        }
        return result;

    }
}
