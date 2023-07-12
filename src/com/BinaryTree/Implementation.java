package com.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class Implementation {

    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
//            this.left = left;
//            this.right = right;
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

    public static Node construct(Integer[] arr) {
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

    public static int size(Node node) {
        if (node==null) {
            return 0;
        }
        int lSize = size(node.left);
        int rSize = size(node.right);
        return lSize+rSize+1;
    }
    public static int sum(Node node) {
        if (node==null) {
            return 0;
        }
        int lSum = sum(node.left);
        int rSum = sum(node.right);
        return lSum+rSum+node.data;
    }
    public static int max(Node node) {
        if (node==null) {
            return Integer.MIN_VALUE;
        }
        int maxInLeft = max(node.left);
        int maxInRight = max(node.right);
        int max = Math.max(maxInLeft,maxInRight);
        return Math.max(max, node.data);
    }
    public static int height(Node node) {
        if (node==null) {
            return -1; // -1 for edges and 0 for nodes
        }
        int heightOfLeft = height(node.left);
        int heightOfRight = height(node.right);
        return Math.max(heightOfLeft,heightOfRight)+1;
    }

    public static void traversalPre(Node node) {
        if (node==null) {
            return;
        }
        System.out.print(node.data + " ");
        traversalPre(node.left);
        traversalPre(node.right);
    }
    public static void traversalPost(Node node) {
        if (node==null) {
            return;
        }
        traversalPost(node.left);
        traversalPost(node.right);
        System.out.print(node.data + " ");
    }
    public static void traversalIn(Node node) {
        if (node==null) {
            return;
        }
        traversalIn(node.left);
        System.out.print(node.data + " ");
        traversalIn(node.right);
    }
    public static void traversalAll(Node node) {
        if (node==null) {
            return;
        }
        System.out.println(node.data + " pre-order");
        traversalAll(node.left);
        System.out.println(node.data + " in-order");
        traversalAll(node.right);
        System.out.println(node.data + " post-order");
    }

    public static void levelOrderTraversal(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        while (qu.size()>0) {
            int count = qu.size();
            for (int i = 0; i < count; i++) {
                node = qu.remove();
                System.out.print(node.data + " ");
                if (node.left!=null) {
                    qu.add(node.left);
                }
                if (node.right!=null) {
                    qu.add(node.right);
                }
            }
            System.out.println();
        }
    }


    public static boolean find(Node node, int data) {
        if (node==null) {
            return false;
        }
        if (node.data==data) {
            return true;
        }
        boolean findLeft = find(node.left, data);
        if (findLeft) {
            return true;
        }
        boolean findRight = find(node.right, data);
        if (findRight) {
            return true;
        }
        return false;
    }

    public static ArrayList<Integer> node_to_root(Node node, int data) {
        if (node==null) {
            return new ArrayList<>();
        }
        if (node.data==data) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        ArrayList<Integer> leftList = node_to_root(node.left, data);
        if (leftList.size()>0) {
            leftList.add(node.data);
            return leftList;
        }
        ArrayList<Integer> rightList = node_to_root(node.right, data);
        if (rightList.size()>0) {
            rightList.add(node.data);
            return rightList;
        }
        return new ArrayList<>();
    }

    public static void printKLevelsDown(Node node, int k) {
        if (node==null || k<0) {
            return;
        }
        if (k==0) {
            System.out.println(node.data);
            return;
        }
        printKLevelsDown(node.left,k-1);
        printKLevelsDown(node.right,k-1);
    }

    public static void main(String[] args) {
        Integer[]arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = construct(arr);
//        display(root);
//        System.out.println(size(root));
//        System.out.println(sum(root));
//        System.out.println(max(root));
//        System.out.println(height(root));
//        traversalPre(root);
//        traversalPost(root);
//        traversalIn(root);
//        traversalAll(root);
//          levelOrderTraversal(root);
//        System.out.println(find(root,31));
//        ArrayList<Integer> list = node_to_root(root,30);
//        System.out.println(list);
        printKLevelsDown(root,2);
    }
}
