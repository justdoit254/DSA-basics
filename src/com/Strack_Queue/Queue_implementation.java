package com.Strack_Queue;


import java.util.Scanner;

public class Queue_implementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.nextLine();
        CustomQueue qu = new CustomQueue(n);
        while (!str.equals("quit")) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(String.valueOf(str.split(" ")[1]));
                qu.add(val);
                //Dynamic Queue
                // st.add2(val);

            } else if (str.startsWith("pop")) {
                int val = qu.remove();
                if (val!=-1) System.out.println(val);

            } else if (str.startsWith("top")) {
                int val = qu.peek();
                if (val!=-1) System.out.println(val);

            } else if (str.startsWith("size")) {
                System.out.println(qu.size());

            } else if (str.startsWith("display")) {
                qu.display();

            }
            str = sc.nextLine();
        }
    }

    public static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            if (size==0) {
                System.out.println("Queue Underflow");
            } else {
                for (int i = 0; i < size; i++) {
                    int idx = (front+i)%data.length;
                    System.out.println(data[idx]+"");
                }
                System.out.println();
            }
        }

        //Normal Queue
        void add(int val) {
            if (size==data.length) {
                System.out.println("Queue Overflow");
            } else {
                int idx = (front+size)%data.length;
                data[idx] = val;
                size++;
            }
        }

        //Dynamic Queue
        void add2(int val) {
            if (size==data.length) {
                int[] new_data = new int[2*data.length];
                for (int i = 0; i < size; i++) {
                    int idx = (front+i)%data.length;
                    new_data[i] = data[idx];
                }
                data = new_data;
                front = 0;
            }
            int idx = (front+size)%data.length;
            data[idx] = val;
            size++;

        }

        int remove() {
            if (size==0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                int el = data[front];
                front = (front+1)%data.length;
                size--;
                return el;
            }
        }

        int peek() {
            if (size==0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return data[front];
            }
        }
    }
}
