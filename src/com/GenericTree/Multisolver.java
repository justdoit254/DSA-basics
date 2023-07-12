package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Multisolver {

    public static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[]arr) {
        Node root = null;
        Stack<Node> stk = new Stack<>();
        for (int j : arr) {
            if (j == -1) {
                stk.pop();
            } else {
                Node t = new Node();
                t.data = j;
                if (stk.size() > 0) {
                    stk.peek().children.add(t);
                } else {
                    root = t;
                }
                stk.push(t);
            }
        }
        return root;
    }

    static int size = 0;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int height = 0;

    public static void multisolver(Node node, int depth) {
        size++;
        min = Math.min(min,node.data);
        max = Math.max(max,node.data);
        height = Math.max(height,depth);

        for (Node child : node.children) {
            multisolver(child,depth+1);
        }

    }

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];
        sc.nextLine();
        String[] values1 = sc.nextLine().split(" ");
        for (int i = 0; i < n1; i++) {
            arr1[i] = Integer.parseInt(values1[i]);
        }
        Node root = construct(arr1);

//        size = 0;
//        min = Integer.MAX_VALUE;
//        max = Integer.MIN_VALUE;
//        height = 0;

        multisolver(root,0);
         System.out.println(size);
         System.out.println(min);
         System.out.println(max);
         System.out.println(height);


    }
}
