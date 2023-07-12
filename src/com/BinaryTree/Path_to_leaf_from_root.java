package com.BinaryTree;

import java.util.Stack;

public class Path_to_leaf_from_root {

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

    public static void pathToLeafFromRoot(Node node, String str, int sum, int lo, int hi) {

         if (node==null) {
             return;
         }

         if (node.left==null && node.right==null) {
             sum += node.data;
             if (sum>=lo && sum<=hi) {
                 System.out.println(str + node.data);
             }
             return;
         }

         pathToLeafFromRoot(node.left, str+node.data+" ", sum+ node.data, lo, hi);
         pathToLeafFromRoot(node.right, str+node.data+" ", sum+ node.data, lo, hi);
    }

    public static void main(String[] args) {
        Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = construct(arr);
        pathToLeafFromRoot(root,"",0,150,250);
    }


}
