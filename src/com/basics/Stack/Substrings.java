package com.basics.Stack;

import java.util.*;

public class Substrings {
    public static void main(String[] args) {
      String S = "geeksforgeeks";
        int n = S.length();
        int m = 3;
        int ans = 0;
       // int x = n-m+1;
        //int count = 0;
        //String[] ans = new String[n*(n+1)/2];
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i <n ; i++) {
            for (int j = i+1; j <=n ; j++) {
                String an = S.substring(i ,j);
                int p = an.length();
                boolean b = true;
                for (int k = 0; k < p; k++) {
                    if (hs.contains(an.charAt(k))){
                        b = false;
                        break;
                    }
                    else hs.add(an.charAt(k));
                }
                hs.clear();
                if (b && p>ans) ans = p;
                /*if (j-i==m) {

                    ans[i] = s.substring(i,j);
                }*/
            }
        }
        System.out.println(ans);
        //Arrays.sort(ans,String.CASE_INSENSITIVE_ORDER);

        //System.out.println(ans[0]);
        //System.out.println(ans[x-1]);
        //System.out.println(ans.);
        //System.out.println(); */
        // Hackerank
        /*Scanner scan=new Scanner(System.in);
        String str=scan.next();
        int k=scan.nextInt();
        SortedSet<String> sets=new TreeSet<String>();
        for(int i=0;i<=str.length()-k;i++){
            sets.add(str.substring(i,i+k));
        }
        System.out.println(sets.first());
        System.out.println(sets.last());*/

    }
}
