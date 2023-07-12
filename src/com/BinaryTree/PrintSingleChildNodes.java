package com.BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class PrintSingleChildNodes {

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int stage;

        public Pair(Node node, int stage) {
            this.node = node;
            this.stage = stage;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Stack<Pair> stk = new Stack<>();
        Pair rtp = new Pair(root, 1);
        stk.push(rtp);
        int idx = 1;
        while (stk.size() > 0) {
            Pair top = stk.peek();
            if (top.stage == 1) {
                top.stage++;
                if (arr[idx] != null) {
                    Node ln = new Node(arr[idx], null, null);
                    top.node.left = ln;
                    Pair lp = new Pair(ln, 1);
                    stk.push(lp);
                }
                idx++;
            } else if (top.stage == 2) {
                top.stage++;
                if (arr[idx] != null) {
                    Node ln = new Node(arr[idx], null, null);
                    top.node.right = ln;
                    Pair lp = new Pair(ln, 1);
                    stk.push(lp);
                }
                idx++;
            } else if (top.stage == 3) {
                stk.pop();
            }
        }
                    return root;
    }

    public static void display(Node node) {
        if (node==null) {
            return;
        }
        String left_part = (node.left==null)? "." : "" +node.left.data;
         String str = " <- " + node.data + " -> ";
        String right_part = (node.right==null)? "." : "" +node.right.data;
        str = left_part + str + right_part;
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void printSingleNodes(Node node, Node parent) {
        if (node==null) {
            return;
        }

        if (parent!=null && parent.left==node && parent.right==null) {
            System.out.println(node.data);
        } else if (parent!=null && parent.right==node && parent.left==null) {
            System.out.println(node.data);
        }

        printSingleNodes(node.left, node);
        printSingleNodes(node.right, node);
    }

    public static void printSingleNodes2(Node node) {
        if (node==null) {
            return;
        }

        if (node.left==null && node.right!=null) {
            System.out.println(node.right.data);
        } else if (node.right==null && node.left!=null) {
            System.out.println(node.left.data);
        }

        printSingleNodes2(node.left);
        printSingleNodes2(node.right);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        sc.nextLine();
        String[] values = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            if (!values[i].equals("n")) {
                arr[i] = Integer.parseInt(values[i]);
            } else {
                arr[i] = null;
            }
        }
        Node root = construct(arr);
//        printSingleNodes(root, null);
        printSingleNodes2(root);
//        display(root);
    }
}
