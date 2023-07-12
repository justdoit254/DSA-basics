package com.LinkedList;

import java.util.Scanner;

public class Remove_duplicates {

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;
        int n;

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if (size==0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
            size++;
            n = size;
        }

        public int size() {
            return size;
        }

        public int getFirst() {
            if (size==0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public void display() {
            for (Node i = head; i != null ; i = i.next) {
                System.out.print(i.data + " ");
            }
            System.out.println();
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size--;
            } else {
                head = head.next;
                size--;
            }
        }


        public void removeDuplicates() {
            LinkedList temp_ld = new LinkedList();
            while (this.size>0) {
                int val = getFirst();
                removeFirst();
                if (temp_ld.size==0 || temp_ld.tail.data!=val) {
                    temp_ld.addLast(val);
                }
            }
            this.head = temp_ld.head;
            this.tail = temp_ld.tail;
            this.size = temp_ld.size;

        }
    }


    public static void main(String[] args) {
        LinkedList ld = new LinkedList();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] values1 = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(values1[i]);
            ld.addLast(d);
        }

        ld.display();
        ld.removeDuplicates();
        ld.display();

    }
}
