package com.basics;


import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        Deque<Integer> d = new LinkedList<>();
//        d.add(1);
//        d.add(2);
//        d.add(3);
//        d.push(5);
//        System.out.println(d);
//        d.remove(1);
//        System.out.println(d);

        String s = "";
        s += "dc";
        System.out.println(s);




//            System.out.println(Arrays.stream(arr).min().getAsInt());

//        System.out.println(0%3);
//        System.out.println(0/3);
    }



    public static void swap ( int[] arr, int idx){
            int temp = arr[idx];
            arr[idx] = arr[idx + 1];
            arr[idx + 1] = temp;
        }

        public static void swap1 ( int x, int y){
            int temp = x;
            x = y;
            y = temp;
        }

        public static boolean isDiv ( int num){
            if (num == 2) {
                return true;
            }
            if (num % 2 != 0) {
                return true;
            }
            return false;
        }
        private static int gcd(int a, int b){
            if (b==0) return a;
            else return gcd(b, a%b);
        }

}


