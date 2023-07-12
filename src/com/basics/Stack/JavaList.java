package com.basics.Stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class JavaList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();         //LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i,sc.nextInt());
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
           String s = sc.next();        //sc.nextLine();
           // sc.nextLine();

            if (s.equals("Insert")) {
                int  n1 = sc.nextInt();
                int n2 = sc.nextInt();
                arr.add(n1,n2);
            }
            else if (s.equals("Delete")){
                int n3 = sc.nextInt();
                arr.remove(n3);
            }


        }
        //System.out.println(arr);
        Iterator it = arr.iterator();
        while(it.hasNext()) {
            Integer ir = (Integer)it.next();
            System.out.println(ir + " ");
        }
    }
}
