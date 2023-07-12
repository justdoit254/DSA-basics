package com.basics.Stack;

import com.basics.Main;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node (int d) {
            data = d;
            next = null;
        }
    }
    public void printlist() {
        Node n = head;
        while (n!=null) {
            System.out.print(n.data);
            System.out.print(" ");
            n = n.next;
        }
    }
    public void push(int x) {
        Node new_node = new Node(x);
        new_node.next = head;
        head = new_node;
    }
    public void insert(Node pre_node , int x) {
        if (pre_node==null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        System.out.println(pre_node.data);
        Node new_node = new Node(x);
        new_node.next = pre_node.next;
        pre_node.next = new_node;
    }
    public void append(int x) {
        Node new_node = new Node(x);
        if (head==null) {
           // head = new_node;
            head = new Node(x);
        }
        Node last = head;
        while (last.next!=null) {
            last = last.next;
        }
        last.next = new_node;
        new_node.next = null;
    }
    public void delete(int x) {
        Node temp = head;
        Node pre = null;
        if (temp == null) {
            return;
        }
        if (temp!=null && temp.data==x) {
            head = temp.next;
            return;
        }
        while (temp!=null && temp.data!=x) {
            pre = temp;
            temp = temp.next;
        }
        pre.next = temp.next;
        //delete(temp.data);

    }
    public void deletenode(int x) {
        if (head==null) {
            return;
        }
        Node temp = head;
        if (x==1) {
            head = temp.next;
            return;
        }
        for (int i = 1; temp!=null && i < x-1; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null)
            return;
        Node pre = temp;
        temp = temp.next;
        pre.next = temp.next;

    }
    public void deletelist(){
        head = null;
    }
    public int getCount() {
        int count = 0;          //int count=1;
        Node temp = head;
        while (temp!=null) {       //temp.next!=null
            temp = temp.next;
            count++;
        }
        return count;
    }
    public int getNth(int index) {
        Node temp = head;
        int position = 1;
        while (temp!=null) {
            if (position==index) {
                return temp.data;
            }
            position++;
            temp = temp.next;
        }
        assert (false);
        return 0;
    }
    public int getNthfromend(int index) {
        Node temp = head;
        int len = getCount();
        int position = len-index+1;
        if (len < index)
            return -1;
        for (int i = 1; i < position; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    public int getmiddle() {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head!=null) {
            while (fast_ptr!=null && fast_ptr.next!=null) {
                fast_ptr = fast_ptr.next.next;
                slow_ptr = slow_ptr.next;
            }
        }
        return slow_ptr.data;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(30);
        Node second = new Node(34);
        Node third = new Node(40);
        ll.head.next = second;
        second.next = third;
        ll.printlist();
        ll.push(21);            //to add element in the beginnning
        System.out.println();
        ll.printlist();
        ll.insert(second , 27);     //to add element at a given index or after a given element
        System.out.println();
        ll.printlist();
        ll.append(70);                  //to add element at the end
        System.out.println();
        ll.printlist();
        ll.delete(34);              //to delete a element
        System.out.println();
        ll.printlist();
        ll.deletenode(2);           //to delete a node with indexing(1)
        System.out.println();
        ll.printlist();
        //ll.deletelist();              //to delete whole list
        System.out.println();
        System.out.println(ll.getCount());      //to get no. of nodes
        System.out.println(ll.getNth(2));       //to get required element with given indexing(1)
        System.out.println(ll.getNthfromend(3));    //to get required element from end with given indexing(1)
        System.out.println(ll.getmiddle());             //to get the middle element


    }
}
