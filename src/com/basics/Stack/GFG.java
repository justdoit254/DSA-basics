package com.basics.Stack;
import java.util.*;

public class GFG {
    public static int max_hist(int k, int[] temp) {
        int[] nsl = new int[k];
        int[] area = new int[k];
        Stack<Integer> stk = new Stack<>();
        for (int j = 0; j < k; j++) {
            while (!stk.isEmpty() && temp[stk.peek()] >= temp[j]) {
                stk.pop();
            }
            if (stk.isEmpty()) nsl[j] = -1;
            else nsl[j] = stk.peek();
            stk.push(j);
        }
        stk.removeAllElements();
        for (int j = k-1; j >= 0; j--) {
            while (!stk.isEmpty() && temp[stk.peek()] >= temp[j]) {
                stk.pop();
            }
            if (stk.isEmpty()) area[j] = (k-nsl[j]-1)*temp[j];
            else area[j] = (stk.peek()-nsl[j]-1)*temp[j];
            stk.push(j);
        }
        stk.removeAllElements();
        Arrays.sort(area);
        return area[k-1];
    }
    public static void main(String[] args) {
        int[][] M = {{ 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },};
        int n = 4;
        int m = 4;


        int[] temp = new int[m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i==0) {
                    temp[j] = M[i][j];
                }
                else if (i==1) {
                    if (M[i][j]==0) temp[j] = 0;
                    else temp[j] = temp[j]+M[i][j];
                }
                else {
                    if (M[i][j]==0 || temp[j]==0) temp[j]=0;
                    else temp[j] = temp[j] +M[i][j];
                }
            }
            int s = max_hist(m, temp);
            if (ans < s) {
                ans = s;
            }
        }
        System.out.println(ans);
    }
}
