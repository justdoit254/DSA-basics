package com.LinkedList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Add_two_list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        LinkedList<Integer> ld1 = new LinkedList<>();
        sc.nextLine();
        String[] values1 = sc.nextLine().split(" ");
        for (int i = 0; i < n1; i++) {
            int val = Integer.parseInt(values1[i]);
            ld1.addLast(val);
        }
        int n2 = sc.nextInt();
        LinkedList<Integer> ld2 = new LinkedList<>();
        sc.nextLine();
        String[] values2 = sc.nextLine().split(" ");
        for (int i = 0; i < n2; i++) {
            int val = Integer.parseInt(values2[i]);
            ld2.addLast(val);
        }
        System.out.println(Arrays.toString(ld1.toArray()));
        System.out.println(Arrays.toString(ld2.toArray()));
        LinkedList<Integer> add_ld = new LinkedList<>();
        int final_carry = add_two_list(ld1, ld1.size(), ld2, ld2.size(), add_ld);
        System.out.println(Arrays.toString(add_ld.toArray()));
    }

    private static int add_two_list(LinkedList<Integer> ld1, int ld1_size, LinkedList<Integer> ld2, int ld2_size, LinkedList<Integer> add_ld) {
        if (ld1.size()==0 && ld2.size()==0) {
            return 0;
        }
        int sum = 0;
        if (ld1_size>ld2_size) {
            int el1 = ld1.removeFirst();
            int carry = add_two_list(ld1, ld1.size(), ld2, ld2.size(), add_ld);
            sum = el1+carry;
        } else if (ld2_size>ld1_size) {
            int el2 = ld2.removeFirst();
            int carry = add_two_list(ld1, ld1.size(), ld2, ld2.size(), add_ld);
            sum = el2+carry;
        } else {
            int el1 = ld1.removeFirst();
            int el2 = ld2.removeFirst();
            int carry = add_two_list(ld1, ld1.size(), ld2, ld2.size(), add_ld);
            sum = el1+el2+carry;
        }
        int c = sum/10;
        int d = sum%10;
        add_ld.addFirst(d);
        return c;

    }
}
