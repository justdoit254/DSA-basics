package com.string;

public class StringCompression {
    public static void main(String[] args) {
        String str = "aabbbccdddefff";
        String str_compressed = str.charAt(0) + "";
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            char prev = str.charAt(i-1);
            if (current!=prev) {
                str_compressed += current;
            }
        }
        System.out.println(str_compressed);
        String str_count =  "";
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            char current = str.charAt(i);
            char prev = str.charAt(i-1);
            if (current==prev) {
                count++;
            }else {
                if (count>=1) {
                    str_count += prev;
                    str_count += count;
                    count = 1;
                }

            }
        }

        System.out.println(str_count+str.charAt(str.length()-1)+count);
    }
}
