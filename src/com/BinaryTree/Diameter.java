package com.BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class Diameter {

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

    public static int height(Node node) {
        if (node==null) {
            return -1; // -1 for edges and 0 for nodes
        }
        int heightOfLeft = height(node.left);
        int heightOfRight = height(node.right);
        return Math.max(heightOfLeft,heightOfRight)+1;
    }

    public static int diameter1(Node node) {
        if (node==null) {
            return 0;
        }

        int left_dia = diameter1(node.left);
        int right_dia = diameter1(node.right);
        int left_and_right_dia = height(node.left) + height(node.right) + 2;

        int dia = Math.max(left_and_right_dia, Math.max(left_dia, right_dia));
        return dia;
    }

    static class DiaPair {
        int ht;
        int dia;

    }
    public static DiaPair diameter2(Node node) {
        if (node==null) {
            DiaPair leafPair = new DiaPair();
            leafPair.ht = -1;
            leafPair.dia = 0;
            return  leafPair;
        }
        DiaPair lp = diameter2(node.left);
        DiaPair rp = diameter2(node.right);
        DiaPair np = new DiaPair();
        np.ht = Math.max(lp.ht, rp.ht)+1;
        np.dia = Math.max((lp.ht+rp.ht+2),Math.max(lp.dia,rp.dia));

        return np;
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
        display(root);
        System.out.println(diameter1(root));
        DiaPair p = diameter2(root);
        System.out.println(p.dia
        );

    }
}
