package com.LinkedList;

import java.util.Scanner;

public class Odd_even_list {

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

        public void oddEven() {
            LinkedList odd_ld = new LinkedList();
            LinkedList even_ld = new LinkedList();
            while (this.size>0) {
                int val = getFirst();
                removeFirst();
                if (val%2==0) {
                    even_ld.addLast(val);
                } else {
                    odd_ld.addLast(val);
                }
            }
            if (odd_ld.size>0 && even_ld.size>0) {
                odd_ld.tail.next = even_ld.head;
                this.head = odd_ld.head;
                this.tail = even_ld.tail;
                this.size = odd_ld.size+even_ld.size;
            } else if (odd_ld.size==0) {
                this.head = even_ld.head;
                this.tail = even_ld.tail;
                this.size = even_ld.size;
            } else if (even_ld.size==0) {
                this.head = odd_ld.head;
                this.tail = odd_ld.tail;
                this.size = odd_ld.size;
            }
        }

        // The following approach will take more approach as elements of original ll are not removed

        public void oddEven2() {
            LinkedList temp_ld = new LinkedList();
            Node temp = this.head;
            while (temp!=null) {
                int val = temp.data;
                temp = temp.next;
                if (val%2!=0) {
                    temp_ld.addLast(val);
                }
            }
            temp = this.head;
            while (temp!=null) {
                int val = temp.data;
                temp = temp.next;
                if (val%2==0) {
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
        int a = sc.nextInt();
        int b = sc.nextInt();

        ld.display();
        ld.oddEven();
        ld.display();
        ld.addFirst(a);
        ld.addLast(b);
        ld.display();

//        ld.oddEven2();
//        ld.display();

    }

}
