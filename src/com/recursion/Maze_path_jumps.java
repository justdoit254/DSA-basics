package com.recursion;

import java.util.ArrayList;

public class Maze_path_jumps {
    public static void main(String[] args) {
        int n = 3, m = 3;
//        System.out.println(get_mazepath_jumps(1,1,n,m));
        print_mazepath_jumps(1,1,n,m,"");
    }

    private static void print_mazepath_jumps(int sr, int sc, int dr, int dc, String ans) {
        if (sr==dr && sc==dc) {
            System.out.println(ans);
            return;
        }
        for (int hstep = 1; hstep <= dc-sc ; hstep++) {
            print_mazepath_jumps(sr,sc+hstep,dr,dc, ans + "h" +hstep);
        }for (int vstep = 1; vstep <= dr-sr ; vstep++) {
            print_mazepath_jumps(sr+vstep,sc,dr,dc, ans + "v" +vstep);
        }for (int dstep = 1; dstep <= dc-sc && dstep <= dr-sr ; dstep++) {
            print_mazepath_jumps(sr+dstep,sc+dstep,dr,dc, ans + "d" +dstep);
        }
    }

    private static ArrayList<String> get_mazepath_jumps(int sr, int sc, int dr, int dc) {
        if (sr==dr && sc==dc) {
            ArrayList<String> one = new ArrayList<>();
            one.add("");
            return one;
        }else if (sr>dr || sc>dc) {
            ArrayList<String> one = new ArrayList<>();
            return one;
        }
        ArrayList<String> paths = new ArrayList<>();
        for (int hstep = 1; hstep <= dc-sc; hstep++) {
            ArrayList<String> hpath = get_mazepath_jumps(sr,sc+hstep,dr,dc);
            for (String val : hpath) {
                paths.add("h" + hstep + val);
            }
        }for (int vstep = 1; vstep <= dr-sr; vstep++) {
            ArrayList<String> vpath = get_mazepath_jumps(sr+vstep,sc,dr,dc);
            for (String val : vpath) {
                paths.add("v" + vstep + val);
            }
        }for (int dstep = 1; dstep <= dc-sc && dstep <= dr-sr; dstep++) {
            ArrayList<String> dpath = get_mazepath_jumps(sr+dstep,sc+dstep,dr,dc);
            for (String val : dpath) {
                paths.add("d" + dstep + val);
            }
        }
        return paths;

    }
}
