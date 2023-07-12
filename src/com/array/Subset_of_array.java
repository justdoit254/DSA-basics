package com.array;

public class Subset_of_array {
    public static void main(String[] args) {
        int[] arr = {10,20,30};
        int  n = (int) Math.pow(2,arr.length);
        for (int i = 0; i < n; i++) {
            String s = " ";
            int temp = i;
            for (int j = arr.length-1 ; j >=0 ; j--) {
                int rem = temp%2;
                if (rem==0) {
                    s = "-  " + s;
                }else s = arr[j] + "  " + s;
                temp = temp / 2;
            }
            System.out.println(s);
        }

    }
}
