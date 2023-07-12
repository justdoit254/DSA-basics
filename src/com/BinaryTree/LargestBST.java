package com.BinaryTree;

import java.util.Scanner;
import java.util.Stack;

public class LargestBST {

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

    private static class BSTPair{
        boolean isBST;
        int max;
        int min;
        Node root;
        int size;
    }
    public static BSTPair largestBST(Node node) {
        if (node==null) {
            BSTPair bp = new BSTPair();
            bp.isBST = true;
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.root = null;
            bp.size = 0;
            return bp;
        }
        BSTPair lp = largestBST(node.left);
        BSTPair rp = largestBST(node.right);

        BSTPair temp = new BSTPair();
        temp.isBST = lp.isBST && rp.isBST && (node.data>= lp.max && node.data<= rp.min);
        temp.min = Math.min(node.data,(Math.min(lp.min, rp.min)));
        temp.max = Math.max(node.data,(Math.max(lp.max, rp.max)));

        if (temp.isBST){
            temp.root = node;
            temp.size = lp.size + rp.size +1;
        } else if (lp.size> rp.size) {
            temp.root = lp.root;
            temp.size = lp.size;
        } else {
            temp.root = rp.root;
            temp.size = rp.size;
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
//        50 25 12 n n 37 n n 75 62 n n 87 n n
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
        BSTPair ans = largestBST(root);
        System.out.println(ans.root.data + "@" + ans.size);
    }
}
