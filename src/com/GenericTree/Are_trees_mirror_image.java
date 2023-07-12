package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Are_trees_mirror_image {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node construct(int[]arr) {
        Node root = null;
        Stack<Node> stk = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==-1) {
                stk.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];
                if (stk.size()>0) {
                    stk.peek().children.add(t);
                } else {
                    root = t;
                }
            }
        }
        return root;
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

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];
        sc.nextLine();
        String[] values2 = sc.nextLine().split(" ");
        for (int i = 0; i < n1; i++) {
            arr2[i] = Integer.parseInt(values2[i]);
        }
        Node root2 = construct(arr2);

        boolean mirror = areMirror(root1,root2);
        System.out.println(mirror);
    }
}
