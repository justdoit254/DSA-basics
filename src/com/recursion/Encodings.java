package com.recursion;

public class Encodings {
    public static void main(String[] args) {
        String str = "12103";
        print_encodings(str,"");

    }

    private static void print_encodings(String str, String ans) {
        if (str.length()==0) {
            System.out.println(ans);
            return;
        } else if (str.length()==1) {
            if (str.charAt(0)=='0') {
                return;
            } else {
                String ch0 = str.substring(0,1);
                String s = str.substring(1);
                String answer = (char) ('a'+Integer.parseInt(ch0)-1) + "";
                print_encodings(s,ans+answer);
            }
        } else {
            if (str.charAt(0)=='0') {
                return;
            } else {
                String ch0 = str.substring(0,1);
                String s = str.substring(1);
                String answer = (char) ('a'+Integer.parseInt(ch0)-1) + "";
                print_encodings(s,ans+answer);

                String ch01 = str.substring(0,2);
                String s1 = str.substring(2);
                String answer1 = (char) ('a'+Integer.parseInt(ch01)-1) + "";
                if (Integer.parseInt(ch01)<=26) {
                    print_encodings(s1,ans+answer1);
                }
            }
        }
    }
}
