package com.string;

public class ToggleCase {
    public static void main(String[] args) {
       StringBuilder str  = new StringBuilder("hE iS gOOD bOY");
        System.out.println(changeCase(str));
    }

     static StringBuilder changeCase(StringBuilder str) {
         for (int i = 0; i < str.length(); i++) {
             char c = str.charAt(i);
             if (c>='A' && c<='Z') {
                 char new_c = (char) (c + 'a' - 'A');
                 str.setCharAt(i,new_c);
             }else if (c>='a' && c<='z'){
                 char new_c = (char) (c + 'A' - 'a');
                 str.setCharAt(i,new_c);
             }
         }
        return str;
    }
}
