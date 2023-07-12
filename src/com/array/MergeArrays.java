package com.array;

import java.util.ArrayList;

public class MergeArrays {
    public static void main(String[] args) {
        int[] nums1 = {2};
        int[] nums2 = {};
        int i1 = 0;
        int i2 = 0;
        int start = 0, end = 0;
        ArrayList<Double> ans = new ArrayList<>();
        while (i1 < nums1.length && i2 < nums2.length) {
            if (nums1[i1] <= nums2[i2]) {
                ans.add((double) nums1[i1]);
                 i1++;
            }
            else {
                ans.add((double) nums2[i2]);
                i2++;
            }
        }
        if (i1 == nums1.length) {
            for (int i = i2 ;i < nums2.length; i++) {
                ans.add((double) nums2[i]);
            }
        }
        if (i2 == nums2.length) {
            for (int i = i1; i < nums1.length; i++) {
                ans.add((double) nums1[i]);
            }
        }
        System.out.println(ans);
        double answer = Median(ans);
        System.out.println(answer);
    }
    static double Median(ArrayList<Double> ans){
        int mid = ans.size()/2;
        if (ans.size()%2==0) {
            return (double) (ans.get(mid)+ ans.get(mid-1))/2;
        }
        return (double) ans.get(mid);
    }
}
