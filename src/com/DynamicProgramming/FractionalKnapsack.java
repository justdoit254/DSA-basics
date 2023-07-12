package com.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {

    public static class Items implements Comparable<Items> {
        int price;
        int weight;
        double rate;

        public Items(int price, int weight, double rate) {
            this.price = price;
            this.weight = weight;
            this.rate = rate;
        }

//        @Override
        public int compareTo(Items o) {
            if (this.rate > o.rate) {
                return 1;
            } else if (this.rate < o.rate) {
                return -1;
            } else  return 0;
//            return Double.compare(this.rate, o.rate);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        int cap = sc.nextInt();

        Items[] items = new Items[n];
        for (int i = 0; i < n; i++) {
            double r = price[i] * 1.0 / weight[i];
            Items newItem = new Items(price[i],weight[i],r);
            items[i] = newItem;
        }
        Arrays.sort(items);

        double maxPrice = 0.0;
        int rc = cap;
        for (int i = items.length-1; i >=0 ; i--) {
            if (rc==0) {
                break;
            }
            if (items[i].weight <= rc) {
                maxPrice += items[i].price;
                rc -= items[i].weight;
            } else {
//                maxPrice += (items[i].price / items[i].weight) * (double) rc;
                maxPrice += (items[i].rate) * (double) rc;
                rc = 0;
                break;
            }
        }
        System.out.println(maxPrice);
    }
}
