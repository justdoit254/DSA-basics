package com.GenericTree;

import java.util.*;

public class Implementation {

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

    public static void display_level_order(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        while (qu.size()>0) {
            Node temp = qu.remove();        //remove
            System.out.print(temp.data + " ");    //print
            qu.addAll(temp.children);       //add
        }
    }
    public static void display_level_order_linewise(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        Queue<Node> cqu = new ArrayDeque<>();
        while (qu.size() > 0) {
            Node temp = qu.remove();        //remove
            System.out.print(temp.data + " ");    //print
            cqu.addAll(temp.children);          // add
            if (qu.size()==0) {
                System.out.println();
                qu = cqu;
                cqu = new ArrayDeque<>();
            }
        }
    }
    public static void display_level_order_linewise2(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        qu.add(new Node(-1));
        while (qu.size() > 0) {
            Node temp = qu.remove();        //remove
            if (temp.data==-1) {
                if (qu.size()>0) {
                    qu.add(new Node(-1));
                    System.out.println();
                }
            } else {
                System.out.print(temp.data + " ");    //print
                qu.addAll(temp.children);
            }
        }
    }
    public static void display_level_order_linewise3(Node node) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.add(node);
        while (qu.size() > 0) {
            int cSize = qu.size();
            for (int i = 0; i < cSize; i++) {
                Node temp = qu.remove();        //remove
                System.out.print(temp.data + " ");    //print
                qu.addAll(temp.children);
            }
            System.out.println();
        }
    }

    private static class Pair{
        Node node;
        int level;

        Pair(Node node,int level) {
            this.node = node;
            this.level = level;
        }
    }
    public static void display_level_order_linewise4(Node node) {
        Queue<Pair> qu = new ArrayDeque<>();
        int level = 1;
        qu.add(new Pair(node, level));
        while (qu.size() > 0) {
            Pair p = qu.remove();
            if (p.level>level) {
                level = p.level;
                System.out.println();
            }
            System.out.print(p.node.data + " ");
            for (Node child : p.node.children) {
                Pair temp = new Pair(child, p.level+1);
                qu.add(temp);

            }
        }
    }

    public static void display_level_order_zigzag(Node node) {
        Stack<Node> st = new Stack<>();
        st.push(node);
        Stack<Node> cst = new Stack<>();
        int level = 1;
        while (st.size() > 0) {
            Node temp = st.pop();        //remove
            System.out.print(temp.data + " ");    //print
            if (level%2==1) {
                for (int i = 0; i < temp.children.size(); i++) {
                    cst.push(temp.children.get(i));
                }
            } else {
                for (int i = temp.children.size()-1; i >=0 ; i--) {
                    cst.push(temp.children.get(i));
                }
            }
            if (st.size()==0) {
                System.out.println();
                st = cst;
                cst = new Stack<>();
                level++;
            }
        }
    }

    public static int size(Node node) {
        int noOfNodes = 0;
        for (Node child : node.children) {
            int nOfChildNodes = size(child);
            noOfNodes += nOfChildNodes;
        }
        noOfNodes++;
        return noOfNodes;
    }

    public static int max(Node node) {
        int max = node.data;
        for (Node child : node.children) {
            int maxOfChild = max(child);
            max = Math.max(max, maxOfChild);
        }
        return max;
    }

    public static boolean find_in_tree(Node node, int find) {
        if (node.data==find) {
            return true;
        }
        for (Node child : node.children) {
           boolean bol = find_in_tree(child,find);
           if (bol) return true;
        }
        return false;
    }

    public static ArrayList<Integer> find_to_root_path(Node node, int find) {
        if (node.data==find) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }
        for (Node child : node.children) {
           ArrayList<Integer> path = find_to_root_path(child,find);
           if (path.size()>0) {
               path.add(node.data);
               return path;
           }
        }
        return new ArrayList<>();
//        return null;
    }

    public static int leastCommonAncestor(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = find_to_root_path(node, d1);
        ArrayList<Integer> path2 = find_to_root_path(node, d2);

        int i = path1.size()-1;
        int j = path2.size()-1;
        while (i>0 && j>0 && Objects.equals(path1.get(i), path2.get(j))) {
            i--;
            j--;
        }
        return path1.get(i+1);

    }

    public static int distanceBetweenTwoNodes(Node node, int d1, int d2) {
        ArrayList<Integer> path1 = find_to_root_path(node, d1);
        ArrayList<Integer> path2 = find_to_root_path(node, d2);
        int numberOfNodes = 0;
        int i = path1.size()-1;
        int j = path2.size()-1;
        while (i>0 && j>0 && Objects.equals(path1.get(i), path2.get(j))) {
            i--;
            j--;
        }
        i++;
//        while (i>0) {
//            numberOfNodes++;
//            i--;
//        }
        j++;
//        while (j>0) {
//            numberOfNodes++;
//            j--;
//        }
//        return numberOfNodes;
        return i+j;
    }

    public static int height(Node node) {
        int h = -1;                         //In terms of edges (if in terms of nodes then h = 0;)
        for (Node child : node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h ++;
        return h;
    }

    public static void traversal(Node node) {
        System.out.println("Node Pre " + node.data);
        for (Node child : node.children) {
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversal(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }
        System.out.println("Node Post " + node.data);
    }

    public static void mirror(Node node) {
        for (Node child : node.children) {
            mirror(child);
        }
        Collections.reverse(node.children);
    }

    public static void IterativePreandPostOrder(Node node) {
        Pair p = new Pair(node,-1);
        Stack<Pair> st = new Stack<>();
        st.push(p);
        String preOrder = "";
        String postOrder = "";
        while (st.size()>0) {
            Pair top = st.peek();
            if (top.level==-1) {
                preOrder += top.node.data + " ";
                top.level++;
            } else if (top.level>=0 && top.level<top.node.children.size()) {
                Pair cp = new Pair(top.node.children.get(top.level),-1);
                st.push(cp);
                top.level++;
            } else {
                postOrder += top.node.data + " ";
                st.pop();
            }
        }
        System.out.println(preOrder);
        System.out.println(postOrder);
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
//        display(root);
//        int sizeOfTree = size(root);
//        System.out.println(sizeOfTree);
//        int maxOfTree = max(root);
//        System.out.println(maxOfTree);
//        int heightOfTree = height(root);
//        System.out.println(heightOfTree);
//        traversal(root);
//        display_level_order(root);
//        display_level_order_linewise(root);
//        display_level_order_linewise2(root);
//        display_level_order_linewise3(root);
//        display_level_order_linewise4(root);
//        display_level_order_zigzag(root);
//        mirror(root);
//        display(root);
//        int find = sc.nextInt();
//        System.out.println(find_in_tree(root,find));
//        ArrayList<Integer> nodeToRootPath = find_to_root_path(root,find);
//        System.out.println(nodeToRootPath);
//        int d1 = sc.nextInt();
//        int d2 = sc.nextInt();
//        int lca = leastCommonAncestor(root,d1,d2);
//        System.out.println(lca);
//        int dis_between_nodes = distanceBetweenTwoNodes(root,d1,d2);
//        System.out.println(dis_between_nodes);
        IterativePreandPostOrder(root);

    }
}
