package com.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class Print_nodes_K_dist_away {

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    public static class Pair{
        Node node;
        int stage;
        public Pair(Node node, int stage) {
            this.node = node;
            this.stage = stage;
        }
    }

    public static Node construct(Integer[] arr){
        Node root = new Node(arr[0]);
        Stack<Pair> stk = new Stack<>();
        Pair rtp = new Pair(root,1);
        stk.push(rtp);
        int idx = 1;
        while (stk.size()>0) {
            Pair top = stk.peek();
            if (top.stage==1) {
                top.stage++;
                if (arr[idx]!=null) {
                    Node ln = new Node(arr[idx]);
                    top.node.left = ln;
                    Pair lp = new Pair(ln,1);
                    stk.push(lp);
                }
                idx++;
            } else if (top.stage==2) {
                 top.stage++;
                if (arr[idx]!=null) {
                    Node ln = new Node(arr[idx]);
                    top.node.right = ln;
                    Pair lp = new Pair(ln,1);
                    stk.push(lp);
                }
                idx++;
            } else if (top.stage==3) {
                stk.pop();
            }
        }
        return root;
    }

        public static ArrayList<Node> node_to_root(Node node, int data) {
        if (node==null) {
            return new ArrayList<>();
        }
        if (node.data==data) {
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            return list;
        }
        ArrayList<Node> leftList = node_to_root(node.left, data);
        if (leftList.size()>0) {
            leftList.add(node);
            return leftList;
        }
        ArrayList<Node> rightList = node_to_root(node.right, data);
        if (rightList.size()>0) {
            rightList.add(node);
            return rightList;
        }
        return new ArrayList<>();
    }

    public static void printKLevelsDown(Node node, int k, Node blocker) {
        if (node==null || k<0 || node==blocker) {
            return;
        }
        if (k==0) {
            System.out.println(node.data);
            return;
        }
        printKLevelsDown(node.left,k-1, blocker);
        printKLevelsDown(node.right,k-1, blocker);
    }

    public static void printKDistanceFar(Node node, int data, int k) {
        ArrayList<Node> list = node_to_root(node,data);
        for (int i = 0; i < list.size(); i++) {
            printKLevelsDown(list.get(i), k-i, i==0?null:list.get(i-1));
        }
    }


    public static void main(String[] args) {
        Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = construct(arr);
        printKDistanceFar(root,37,2);
    }

}
