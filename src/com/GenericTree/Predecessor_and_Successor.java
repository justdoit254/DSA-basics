package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Predecessor_and_Successor {

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

    static Node predecessor;
    static Node successor;
    static int state;

    public static void predecessorAndSuccessor(Node node, int data) {
        if (state==0) {
            if (node.data==data) {
                state++;
            } else {
                predecessor = node;
            }
        } else if (state==1) {
            successor = node;
            state++;
        }

        for (Node child : node.children) {
            predecessorAndSuccessor(child,data);
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

        int data = sc.nextInt();
        predecessor = null;
        successor = null;
        state = 0;

        predecessorAndSuccessor(root,data);
        if (predecessor==null) {
            System.out.println("Predecessor = Not found");
        } else {
            System.out.println("Predecessor = " + predecessor.data);
        }
        if (successor==null) {
            System.out.println("Successor = Not found");
        } else {
            System.out.println("Successor = " + successor.data);
        }
    }
}
