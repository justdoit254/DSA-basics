package com;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;


 class ListNode {
     int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class Rough {
    public static void main(String[] args) {
//      Stack s = new Stack();
//      s.push(30);
//      s.push(-5);
//      s.push(3);
//      s.push(5);
//      s.push(2);
//      s.push(1);
       int[] arr = {1,1};
       int size = arr.length;
       Stack<Integer> stk = new Stack<>();
//       Find the array of smaller element to the right
        int[] ans_r = new int[size];
        for (int i = size-1; i >=0 ; i--) {
            if (stk.empty()) {
                ans_r[i] = size;
                stk.push(i);
            }
            else {
                if (arr[stk.peek()] < arr[i]) {
                    ans_r[i] = stk.peek();
                    stk.push(i);
                }
                else {
                    while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                        stk.pop();
                    }
                    if (stk.empty()) ans_r[i] = size;
                    else ans_r[i] = stk.peek();
                    stk.push(i);
                }
            }
        }
        System.out.println(Arrays.toString(ans_r));
        stk.clear();
//        Find the array of smaller element to the left
        int[] ans_l = new int[size];
        for (int i = 0; i < size; i++) {
            if (stk.empty()) {
                ans_l[i] = -1;
                stk.push(i);
            }
            else {
               if (arr[stk.peek()] < arr[i]) {
                    ans_l[i] = stk.peek();
                    stk.push(i);
                }
                else {
                    while (!stk.isEmpty() && arr[stk.peek()] >= arr[i]) {
                        stk.pop();
                    }
                    if (stk.empty()) ans_l[i] = -1;
                    else ans_l[i] = stk.peek();
                    stk.push(i);
                }
            }
        }
        System.out.println(Arrays.toString(ans_l));
//        Calculation of maximum area
        int max_area = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            int area = (ans_r[i] - ans_l[i] - 1) * arr[i];
            if (area > max_area) max_area = area;
        }
        System.out.println(max_area);


    }



    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head = prev;
        return head;

    }
}




//       static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//
//    }


