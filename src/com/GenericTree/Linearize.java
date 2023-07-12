package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Linearize {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();

        Node() {

        }
        Node(int data) {
            this.data = data;
        }
    }

    public static Node construct(int[] arr) {
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

    public static void display(Node node) {
        String str = node.data + "->";
        for (Node child : node.children) {
            str += child.data + ",";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

//    public static void linearize(Node node) {
//        for (Node child : node.children) {
//            linearize(child);
//        }
//        while (node.children.size()>1) {
//            Node lc = node.children.remove(node.children.size()-1);
//            Node slc = node.children.get(node.children.size()-1);
//            Node slt = getTail(slc);
//            slt.children.add(lc);
//        }
//    }
//
//    private static Node getTail(Node node) {
//        while (node.children.size()==1) {
//            node = node.children.get(0);
//        }
//        return node;
//    }

    public static Node linearize2(Node node) {
        if (node.children.size()==0) {
            return node;
        }
        Node lt = linearize2(node.children.get(node.children.size()-1));
        while (node.children.size()>1) {
            Node lc = node.children.remove(node.children.size()-1);
            Node slc = node.children.get(node.children.size()-1);
            Node slt = linearize2(slc);
            slt.children.add(lc);
        }
        return lt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        sc.nextLine();
        String[] values = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(values[i]);
        }
        Node root = construct(arr);
        display(root);
//        linearize(root);
//        System.out.println();
//        display(root);
        linearize2(root);
        System.out.println();
        display(root);

    }
}
