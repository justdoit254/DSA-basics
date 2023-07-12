package com.recursion;

import java.util.ArrayList;

public class Kpc {
    public static void main(String[] args) {
        String str = "678";
//        System.out.println(get_keypad_combination(str));
        print_keypad_combination(str,"");
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    private static void print_keypad_combination(String ques, String ans) {
        if (ques.length()==0) {
            System.out.println(ans);
            return;
        }
        char ch = ques.charAt(0);
        String rest_ques = ques.substring(1);
        String s = codes[ch - '0'];
        for (int i = 0; i < s.length(); i++) {
            print_keypad_combination(rest_ques,ans+s.charAt(i));
        }
    }

    private static ArrayList get_keypad_combination(String str) {
        if (str.length()==0) {
            ArrayList<String> one = new ArrayList<>();
            one.add("");
            return one;
        }
        char c = str.charAt(0);
        String sub = str.substring(1);
        ArrayList<String> basic = get_keypad_combination(sub);
        ArrayList<String> result = new ArrayList<>();
        String s = codes[c - '0'];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (String value : basic) {
                result.add(ch + value);
            }
        }
        return result;

    }
}
