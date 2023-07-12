package com.recursion;

import java.util.ArrayList;

public class Stairs_path {
    public static void main(String[] args) {
        int n = 4;
//        System.out.println(get_stairspath(n));
        print_stairspath(n,"");
    }

    private static void print_stairspath(int n, String ans) {
        if (n==0) {
            System.out.println(ans);
            return;
        }if (n<0) {
            return;
        }
        print_stairspath(n-1,ans+"1");
        print_stairspath(n-2,ans+"2");
        print_stairspath(n-3,ans+"3");
    }

    private static ArrayList get_stairspath(int n) {
        if (n==0) {
            ArrayList<String> one = new ArrayList<>();
            one.add("");
            return one;
        }
        if (n<0) {
            ArrayList<String> one = new ArrayList<>();
            return one;
        }
        ArrayList<String> path1 = get_stairspath(n-1);
        ArrayList<String> path2 = get_stairspath(n-2);
        ArrayList<String> path3 = get_stairspath(n-3);
        ArrayList<String> paths = new ArrayList<>();
        for (String val : path1) {
            paths.add("1" + val);
        }for (String val : path2) {
            paths.add("2" + val);
        }for (String val : path3) {
            paths.add("3" + val);
        }
//        System.out.println("path1" + path1);
//        System.out.println("path2" + path2);
//        System.out.println("path3" + path3);
//        System.out.println("paths" + paths);
        return paths;
    }
}
