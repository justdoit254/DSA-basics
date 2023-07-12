package com.array;

public class BarChart {
    public static void main(String[] args) {
        int[] arr = {3,1,0,7,5};
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {   //to get maximum element
            if (arr[i]>max)  max = arr[i];
        }
        for (int i = max; i >=0 ; i--) {
            for (int j = 0; j < n; j++) {
                if ((max-arr[j])<i) System.out.print("x" + " ");
                else System.out.print("-" + " ");
            }
            System.out.println();

        }
    }
}
