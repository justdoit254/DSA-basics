package com.basics.Stack;

public class BinaryTree {
    static class Node {
        int key;
        Node left, right;
        Node(int key) {
            this.key = key;
            Node left = null;
            Node right = null;
        }
    }
    static Node root;
   // static Node temp = root;
    static void inorder(Node temp) {
        if (temp==null) return;

    }


    public static void main(String[] args) {
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        System.out.println("Initial Tree: ");
        inorder(root);

    }
}
