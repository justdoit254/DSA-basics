package com.recursion;

import java.util.ArrayList;

public class Maze_path {
    public static void main(String[] args) {
        int m = 3 , n = 3;
//        System.out.println(get_mazepath(1,1,n,m));
        print_mazepath(1,1,n,m,"");
    }

    private static void print_mazepath(int sr, int sc, int dr, int dc, String ans) {
        if (sc==dc && sr==dr) {
            System.out.println(ans);
            return;
        }
        if (sc<dc) {
            print_mazepath(sr,sc+1,dr,dc,ans+"h");
        }if (sr<dr) {
            print_mazepath(sr+1,sc,dr,dc,ans+"v");
        }
    }

    private static ArrayList get_mazepath(int sr, int sc, int dr, int dc) {
        if (sr==dr && sc==dc) {
            ArrayList<String> one = new ArrayList<>();
            one.add("");
            return one;
        }
        ArrayList<String> hpath = new ArrayList<>();
        ArrayList<String> vpath = new ArrayList<>();
        if (sc<dc) {
            hpath = get_mazepath(sr,sc+1,dr,dc);
        }
        if(sr<dr) {
            vpath = get_mazepath(sr+1,sc,dr,dc);
        }
        ArrayList<String> ans = new ArrayList<>();

        for (String val : hpath) {
            ans.add("h" + val);
        }for (String val : vpath) {
            ans.add("v" + val);
        }
        return ans;

    }
}
