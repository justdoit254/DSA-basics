package com.LinkedList;

import java.util.Scanner;

public class K_reverse_list {

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
            if (size == 0) {
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
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public void display() {
            for (Node i = head; i != null; i = i.next) {
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

        void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;
            if (size == 0) {
                tail = temp;
            }
            size++;
        }

        public int getLast() {
            if (size==0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public void removeLast() {
            if (size==0) {
                System.out.println("List is empty");
            } else if (size==1){
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size-2; i++) {
                    temp = temp.next;
                }
                tail = temp;
                tail.next = null;
                size--;
            }
        }


        public void k_reverse(int k) {
            LinkedList first = new LinkedList();
            LinkedList last = new LinkedList();
            while (this.size>0) {
                int val = this.getFirst();
                this.removeFirst();
                if (first.size==k) {
                    while (first.size>0) {
                        int el = first.getFirst();
                        first.removeFirst();
                        last.addLast(el);
                    }
                }
                first.addFirst(val);
            }
            while (first.size>0) {
                int el = first.getLast();
                first.removeLast();
                last.addLast(el);
            }
            this.head = last.head;
            this.tail = last.tail;
            this.size = last.size;
        }
        //With slight diff approach then in tutorial
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
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        ld.display();
        ld.k_reverse(k);
        ld.display();
        ld.addFirst(a);
        ld.addLast(b);
        ld.display();
    }
}
