package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Ceil_and_Floor {

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

    static int ceil;
    static int floor;

    public static void ceilAndFloor(Node node, int data) {
//        if (node.data>data && node.data<ceil) {
//            ceil = node.data;
//        }
//        if (node.data<data && node.data>floor) {
//            floor = node.data;
//        }
        if (node.data>data) {
            ceil = Math.min(ceil,node.data);
        }
        if (node.data<data) {
            floor = Math.max(floor,node.data);
        }

        for (Node child : node.children) {
            ceilAndFloor(child,data);
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

        ceil = Integer.MAX_VALUE;
        floor = Integer.MIN_VALUE;
        int data = sc.nextInt();
        ceilAndFloor(root,data);
        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);
    }
}
