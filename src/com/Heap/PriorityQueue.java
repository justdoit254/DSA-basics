package com.Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class PriorityQueue {

    public static class priorityQueue {
        ArrayList<Integer> data;
        public priorityQueue() {
            data = new ArrayList<>();
        }
//        Efficient Constructor
        public priorityQueue(int[] arr) {
            data = new ArrayList<>();
            for (int val : arr) {
                data.add(val);
            }

            for (int i = data.size()/2 - 1; i >= 0 ; i--) {
                downheapify(i);
            }
        }

        public void add(int val) {
            data.add(val);
            upheapify(data.size()-1);
        }
        private void upheapify(int i) {
            if (i==0) {
                return;
            }
            int pIdx = (i-1)/2;
            if (data.get(pIdx)>data.get(i)){
                swap(pIdx,i);
                upheapify(pIdx);
            }
        }
        private void swap(int pIdx, int i) {
            int idx1 = data.get(pIdx);
            int idx2 = data.get(i);
            data.set(i,idx1);
            data.set(pIdx,idx2);
        }

        public int remove() {
            if (this.size()==0) {
                System.out.println("Underflow");
                return -1;
            }
            swap(0,data.size()-1);
            int value = data.remove(data.size()-1);
            downheapify(0);
            return value;
        }
        private void downheapify(int i) {
            int minIdx = i;
            int lChild = 2*i + 1;
            if (lChild<data.size() && data.get(lChild)<data.get(minIdx)) {
                minIdx = lChild;
            }
            int rChild = 2*i + 2;
            if (rChild<data.size() && data.get(rChild)<data.get(minIdx)) {
                minIdx = rChild;
            }
            if (minIdx != i) {
                swap(minIdx,i);
                downheapify(minIdx);
            }
        }

        public int peek() {
            if (this.size()==0) {
                System.out.println("Underflow");
                return -1;
            }
            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        priorityQueue qu = new priorityQueue();
//
//        String str = sc.nextLine();
//        while (!str.equals("quit")) {
//            if (str.startsWith("add")) {
//                int val = Integer.parseInt(str.split(" ")[1]);
//                qu.add(val);
//            } else if (str.startsWith("remove")) {
//                int val = qu.remove();
//                if (val != -1) {
//                    System.out.println(val);
//                }
//            } else if (str.startsWith("peek")) {
//                int val = qu.peek();
//                if (val != -1) {
//                    System.out.println(val);
//                }
//            } else if (str.startsWith("size")) {
//                System.out.println(qu.size());
//            }
//             str = sc.nextLine();
//
//        }
        int[] arr = {10,2,17,3,18,9,22};
        priorityQueue pQ = new priorityQueue(arr);
        while (pQ.size()>0) {
            System.out.println( pQ.remove());
        }

    }

}
