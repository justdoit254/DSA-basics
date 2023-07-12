package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class RemoveLeaves {

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

    public static void removeLeaves(Node node) {
        for (int i = node.children.size()-1; i >=0 ; i--) {
            Node child = node.children.get(i);
            if (child.children.size()==0) {
                node.children.remove(child);
            }
        }
        for (Node child : node.children) {
            removeLeaves(child);
        }
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
        removeLeaves(root);
        System.out.println();
        display(root);
    }
}
