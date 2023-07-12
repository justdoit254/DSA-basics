package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class MaximumSubtreeSumNode {
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

    static int mSum;
    static int mSumNode;

    public static int Maximum_subtree_sum_node(Node node) {
        int sum = node.data;

        for (Node child : node.children) {
            int nodeSum = Maximum_subtree_sum_node(child);
            sum += nodeSum;
        }

        if (mSum<sum) {
            mSum = sum;
            mSumNode = node.data;
        }

        return sum;
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
//        display(root);

        mSum = Integer.MIN_VALUE;
        mSumNode = 0;
        Maximum_subtree_sum_node(root);
        System.out.println(mSumNode + "@" + mSum);
    }
}
