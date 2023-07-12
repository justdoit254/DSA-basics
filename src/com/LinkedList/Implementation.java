package com.LinkedList;


import java.util.Scanner;

public class Implementation {

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

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAtIndex(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid Index");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
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

        public void addAtIndex(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid Index");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node new_node = new Node();
                new_node.data = val;
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                new_node.next = temp.next;
                temp.next = new_node;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }
                tail = temp;
                tail.next = null;
                size--;
            }
        }

        public void removeAtIndex(int idx) {
            if (idx < 0 || idx >= size) {
                System.out.println("Invalid Index");
            } else if (idx == 0) {
                removeFirst();
            } else if (idx == size - 1) {
                removeLast();
            } else {
                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                temp.next = temp.next.next;
                size--;
            }
        }

        public void reverseDI() {
            Node temp_s = head;     //initialize starting pointer to the head
            for (int i = 0; i < size / 2; i++) {
                Node temp_e = head;     //pointer to reach at the required node
                for (int j = 0; j < size - i - 1; j++) {
                    temp_e = temp_e.next;       //make the pointer reach at required node
                }
                //swap the data
                int temp_data = temp_s.data;
                temp_s.data = temp_e.data;
                temp_e.data = temp_data;
                // move the initialized pointer to next node
                temp_s = temp_s.next;
            }
        }

        // Other way of reversing linked list iteratively

        private Node getNodeAt(int idx) {
            Node temp = head;
            for (int i = 0; i < idx; i++) {
                temp = temp.next;
            }
            return temp;
        }

        public void reverseDI2() {
            int li = 0;
            int ri = size - 1;

            while (li < ri) {
                Node left = getNodeAt(li);
                Node right = getNodeAt(ri);

                int temp = left.data;
                left.data = right.data;
                right.data = temp;

                li++;
                ri--;
            }
        }

        public void reversePI() {
            Node temp = head;
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - i - 2; j++) {
                    temp = temp.next;
                }
                temp.next.next = temp;
                temp = head;
            }
            temp.next = null;
            temp = tail;
            tail = head;
            head = temp;
        }

        //        Optimised reversePI
        public void reversePI2() {
            Node prev = null;
            Node curr = head;
            while (curr != null) {
                Node temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            Node temp = head;
            head = tail;
            tail = temp;
        }

        public int kthFromLast(int K) {
            Node pSlow = head;
            Node pFast = head;
            for (int i = 0; i < K; i++) {
                pFast = pFast.next;
            }
            while (pFast.next != null) {
                pSlow = pSlow.next;
                pFast = pFast.next;
            }
            return pSlow.data;
        }

        public int mid() {
            Node pSlow = head;
            Node pFast = head;
            while (pFast.next != tail && pFast != tail) {
                pFast = pFast.next.next;
                pSlow = pSlow.next;
            }
            return pSlow.data;
        }

        private void displayreverse_helper(Node node) {
            if (node==null) {
                return;
            }
            displayreverse_helper(node.next);
            System.out.print(node.data+" ");
        }


        public void display_reverse() {
            displayreverse_helper(head);
            System.out.println();
        }

        private void reversePR_helper(Node node) {
            if (node==tail) {
                return;
            }
            reversePR_helper(node.next);
            node.next.next = node;
        }

        public void reversePR() {
            reversePR_helper(head);
            Node temp = head;
            head = tail;
            tail = temp;
            tail.next = null;
        }

    }

    public static void main(String[] args) {
        LinkedList ld = new LinkedList();
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        while (!s.startsWith("quit")) {
            if (s.startsWith("addLast")) {
                int val = Integer.parseInt(s.split(" ")[1]);
                ld.addLast(val);
            } else if (s.startsWith("size")) {
                System.out.println(ld.size());
            } else if (s.startsWith("display")) {
                ld.display();
            } else if (s.startsWith("removeFirst")) {
                ld.removeFirst();
            } else if (s.startsWith("getFirst")) {
                int val = ld.getFirst();
                if (val != -1) System.out.println(val);
            } else if (s.startsWith("getLast")) {
                int val = ld.getLast();
                if (val != -1) System.out.println(val);
            } else if (s.startsWith("getAtIndex")) {
                int idx = Integer.parseInt(s.split(" ")[1]);
                int val = ld.getAtIndex(idx);
                if (val != -1) System.out.println(val);
            } else if (s.startsWith("addFirst")) {
                int val = Integer.parseInt(s.split(" ")[1]);
                ld.addFirst(val);
            } else if (s.startsWith("addAt")) {
                int idx = Integer.parseInt(s.split(" ")[1]);
                int val = Integer.parseInt(s.split(" ")[2]);
                ld.addAtIndex(idx, val);
            } else if (s.startsWith("removeLast")) {
                ld.removeLast();
            } else if (s.startsWith("removeAt")) {
                int idx = Integer.parseInt(s.split(" ")[1]);
                ld.removeAtIndex(idx);
            } else if (s.startsWith("reverseDI")) {
                ld.reverseDI();
            } else if (s.startsWith("reverseDI2")) {
                ld.reverseDI2();
            } else if (s.startsWith("reversePI")) {
                ld.reversePI();
            } else if (s.startsWith("reversePI2")) {
                ld.reversePI2();
            } else if (s.startsWith("kthFromEnd")) {
                int K = Integer.parseInt(s.split(" ")[1]);
                System.out.println(ld.kthFromLast(K));
            } else if (s.startsWith("mid")) {
                System.out.println(ld.mid());
            } else if (s.startsWith("rev_display")) {
                ld.display_reverse();
            } else if (s.startsWith("reversePR")) {
                ld.reversePR();
            }

            s = sc.nextLine();
        }

        System.out.println(ld);
    }
}
