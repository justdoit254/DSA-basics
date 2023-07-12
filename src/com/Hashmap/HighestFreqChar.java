package com.Hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class HighestFreqChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
//        zmszeqxllzvheqwrofgcuntypejcxovtaqbnqyqlmrwitc
        HashMap<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (hm.containsKey(ch)) {
                int oldF = hm.get(ch);
                int newF = oldF +1;
                hm.put(ch,newF);
            } else {
                hm.put(ch,1);
            }
        }
        char hfc = str.charAt(0);
        for (Character key : hm.keySet()) {
            if (hm.get(key)>hm.get(hfc)) {
                hfc = key;
            }
        }
        System.out.println(hfc);

    }
}
