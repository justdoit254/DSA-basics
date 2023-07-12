package com.LinkedList;

import java.util.Scanner;

public class Palindrome {

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

        Node p_left;        //really imp define outside but initialize inside function
        public boolean Is_Palindrome() {
            p_left = head;
            return Is_Palindrome_helper(head);
        }

        private boolean Is_Palindrome_helper(Node p_right) {
            if (p_right==null) {
                return true;
            }
            boolean bol = Is_Palindrome_helper(p_right.next);
            if (!bol) {
                return false;
            } else if (p_right.data!= p_left.data) {
                return false;
            }
            p_left= p_left.next;
            return true;
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
        System.out.println(ld.Is_Palindrome());
    }
}
