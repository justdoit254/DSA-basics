package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Kth_Smallest {

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

    public static void ceilAndFloor(Node node, int data) {
        if (node.data>data && node.data<ceil) {
            ceil = node.data;
        }

        for (Node child : node.children) {
            ceilAndFloor(child,data);
        }
    }

    public static int kth_Smallest(Node node, int k) {
        int data = Integer.MIN_VALUE;
        ceil = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ceilAndFloor(node,data);
            data = ceil;
            ceil = Integer.MAX_VALUE;
        }
        return data;
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
        int k = sc.nextInt();
        int Kth_smallest = kth_Smallest(root,k);
        System.out.println(Kth_smallest);

    }
}
