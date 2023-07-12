package com.basics.Stack;

import java.util.*;
//import java.io.*;
//import java.

public class PushPopPeek {
    public static void main(String[] args) {
        Stack<String> s = new Stack<String>();
        s.push("make");
        s.push("new");
        s.push("file");
        System.out.println(s);
        System.out.println(s.pop());
        System.out.println(s);
        System.out.println(s.peek());
        System.out.println(s);
        System.out.println(s.search("make"));
        System.out.println(s.isEmpty());

    }
}
