package com.GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DiameterOfTree {

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

    static int diameter;

    public static int treeDiameter(Node node) {
        int longestNode = -1;
        int secondLongestNode = -1;

        for (Node child : node.children) {
            int node_dia = treeDiameter(child);
            if (node_dia>longestNode) {
                secondLongestNode = longestNode;
                longestNode = node_dia;
            } else if (node_dia>secondLongestNode) {
                secondLongestNode = node_dia;
            }

        }

        if (longestNode+secondLongestNode+2>diameter) {
            diameter = longestNode + secondLongestNode + 2;
        }

        longestNode++;
        return longestNode;

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

       diameter = 0;
       treeDiameter(root);
        System.out.println(diameter);


    }

}
