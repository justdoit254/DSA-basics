package com.string;

public class Difference_of_consecutive_character {
    public static void main(String[] args) {
        String str = "pepCODinG";
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            sb.append((str.charAt(i)-str.charAt(i-1)));
            sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
