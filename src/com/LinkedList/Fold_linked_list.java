package com.LinkedList;

import java.util.Scanner;

public class Fold_linked_list {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        public void display() {
            for (Node i = head; i != null; i = i.next) {
                System.out.print(i.data + " ");
            }
            System.out.println();
        }

        Node p_left;

        public void fold_ld() {
            p_left = head;
            fold_ld_helper(head, 0);
        }

        private void fold_ld_helper(Node p_right, int count) {
            if (p_right==null) {
                return;
            }
            fold_ld_helper(p_right.next, count+1);      //imp count+1 not count++
            if (count>size/2) {
                Node temp = p_left.next;
                p_left.next = p_right;
                p_right.next = temp;
                p_left = temp;
            } else if (count==size/2) {
                tail = p_right;
                p_right.next = null;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList ld = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] values = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(values[i]);
            ld.addLast(val);
        }
        ld.fold_ld();
        ld.display();
    }
}
