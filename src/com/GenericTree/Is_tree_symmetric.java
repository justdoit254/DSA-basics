package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Is_tree_symmetric {


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

    public static boolean isSymmetric(Node node) {
        return areMirror(node, node);
    }

    public static boolean areMirror(Node node1, Node node2) {
        if (node1.children.size()!=node2.children.size()) {
            return false;
        }
        for (int i = 0; i < node1.children.size(); i++) {
            int j = node1.children.size()-1-i;
            Node child1 = node1.children.get(i);
            Node child2 = node2.children.get(j);
            boolean bol = areMirror(child1,child2);
            if (!bol) {
                return false;
            }
        }
        return true;
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
        Node root1 = construct(arr1);

        boolean symmetric = isSymmetric(root1);
        System.out.println(symmetric);
    }
}
