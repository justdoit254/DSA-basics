package com.LinkedList;

import java.util.Scanner;

public class Merge_sort {

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

        public static LinkedList mergeSort(Node head, Node tail) {
            if (head==tail) {
                LinkedList list = new LinkedList();
                list.addLast(head.data);
                return list;
            }
            Node mid = midNode(head,tail);
            LinkedList listLeft = mergeSort(head,mid);
            LinkedList listRight = mergeSort(mid.next,tail);
            LinkedList listSort = Merge_sorted_list(listLeft,listRight);
            return listSort;
        }

        private static Node midNode(Node head, Node tail) {
            Node f = head;
            Node s = head;
          while (f != tail && f.next != tail) {
            f = f.next.next;
            s = s.next;
          }
          return s;
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        LinkedList ld = new LinkedList();
        String[] values = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(values[i]);
            ld.addLast(val);
        }

        LinkedList sorted = LinkedList.mergeSort(ld.head, ld.tail);
        sorted.display();
        ld.display();

    }
}
