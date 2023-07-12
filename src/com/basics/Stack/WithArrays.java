package com.basics.Stack;

import java.util.Stack;
class see {
    static final int MAX = 10;
    int[] a = new int[MAX];
    int top;
    boolean isEmpty() {
        return (top<0);
    }
    see() {
        top = -1;
    }

}

public class WithArrays {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + "is popped out");
        System.out.println(s.peek() + "is peeked out");
    }
}
