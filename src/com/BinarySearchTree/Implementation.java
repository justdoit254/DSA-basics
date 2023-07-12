package com.BinarySearchTree;

import java.util.Scanner;

public class Implementation {

    public static class Node{
        Node left;
        Node right;
        int data;
        public Node(int data, Node left, Node right) {
            this.data = data;
             this.left = left;
            this.right = right;
        }
    }

    public static Node construct(int[]arr, int lo, int hi) {
        if (lo>hi) {
            return null;
        }
        int mid = (lo+hi)/2;

        int data = arr[mid];
        Node ls = construct(arr,lo,mid-1);
        Node rs = construct(arr,mid+1,hi);

        Node node = new Node(data,ls,rs);
        return node;
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
        if (node.right!=null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public static int min(Node node) {
        if (node.left!=null) {
            return min(node.left);
        } else {
            return node.data;
        }
    }

    public static boolean find(Node node, int data) {
        if (node==null) {
            return false;
        }
        if (data> node.data) {
           return find(node.right,data);
        } else if (data< node.data) {
           return find(node.left,data);
        } else {
            return true;
        }
//        return false;
    }

    public static Node add(Node node, int data) {
        if (node == null ){
            return new Node(data, null, null);
        }

        if (data>node.data) {
            node.right = add(node.right, data);
        } else if (data< node.data) {
            node.left = add(node.left, data);
        }
        return node;
    }

    public static Node remove(Node node, int data) {
        if (node==null) {
            return null;
        }

        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data<node.data) {
            node.left = remove(node.left, data);
        } else {
            if (node.left!=null && node.right!=null) {
                int lMax = max(node.left);
                node.data = lMax;
                node.left = remove(node.left, lMax);
                return node;

            } else if (node.left!=null) {
                return node.left;
            } else if (node.right!=null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }
    static int sum = 0;
    public static void replaceSum(Node node) {
        if (node==null) {
            return;
        }
        replaceSum(node.right);
        int data = node.data;
        node.data = sum;
        sum += data;
        replaceSum(node.left);
    }

    public static int lca(Node node, int d1, int d2) {
        if(node==null){
            return 0;
        }
        if (d1< node.data && d2< node.data) {
            return lca(node.left, d1, d2);
        } else if (d2> node.data && d1> node.data) {
            return lca(node.right, d1, d2);
        } else {
            return node.data;
        }
//        return node.data;
    }

    public static void printInRange(Node node, int d1, int d2) {
        if (node==null) {
            return;
        }
        if (d1< node.data && d2< node.data) {
            printInRange(node.left, d1, d2);
        } else if (d2> node.data && d1> node.data) {
            printInRange(node.right, d1, d2);
        } else {
            printInRange(node.left,d1,d2);
            System.out.println(node.data);
            printInRange(node.right,d1,d2);
        }
    }

    public static void targetSumPair(Node root, Node node, int sum) {
        if (node==null) {
            return;
        }
        targetSumPair(root, node.left, sum);

        int req = sum - node.data;
        if (find(root,req)) {
            System.out.println(node.data + " " + req);
        }
        targetSumPair(root, node.right, sum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
//        12 25 37 50 62 75 87
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Node root = construct(arr,0,n-1);
        display(root);
//        int size = size(root);
//        System.out.println(size);
//        int sum = sum(root);
//        System.out.println(sum);
//        int min = min(root);
//        System.out.println(min);
//        int max = max(root);
//        System.out.println(max);
//        int num = sc.nextInt();
//        boolean find = find(root,num);
//        System.out.println(find);
//        int new_data = sc.nextInt();
//        Node new_node = add(root, new_data);
//        display(root);
        int remove_data = sc.nextInt();
        Node new_node = remove(root, remove_data);
        display(root);
//        replaceSum(root);
//        display(root);
//        int lca = lca(root,12,62);
//        System.out.println(lca);
//        printInRange(root,36,61);
//        targetSumPair(root,root,100);

    }
}
