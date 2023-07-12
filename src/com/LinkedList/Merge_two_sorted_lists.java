package com.LinkedList;

import java.util.Scanner;

public class Merge_two_sorted_lists {

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

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }

        public static LinkedList Merge_sorted_list(LinkedList l1, LinkedList l2) {
            Node h1 = l1.head;
            Node h2 = l2.head;
            LinkedList merged_ld = new LinkedList();
            while (h1!=null && h2!=null) {
                if (h1.data<= h2.data) {
                    merged_ld.addLast(h1.data);
                    h1 = h1.next;
                } else {
                    merged_ld.addLast(h2.data);
                    h2 = h2.next;
                }
            }
            while (h1!=null) {
                merged_ld.addLast(h1.data);
                h1 = h1.next;
            }
            while (h2!=null) {
                merged_ld.addLast(h2.data);
                h2 = h2.next;
            }
            return merged_ld;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        LinkedList ld1 = new LinkedList();
        for (int i = 0; i < n1; i++) {
            ld1.addLast(sc.nextInt());
        }
        int n2 = sc.nextInt();
        LinkedList ld2 = new LinkedList();
        for (int i = 0; i < n2; i++) {
            ld2.addLast(sc.nextInt());
        }

        LinkedList merged = LinkedList.Merge_sorted_list(ld1,ld2);
        merged.display();
        ld1.display();
        ld2.display();
    }
}
