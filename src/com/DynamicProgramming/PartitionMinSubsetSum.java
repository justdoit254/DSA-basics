package com.DynamicProgramming;

public class PartitionMinSubsetSum {
    public static void main(String[] args) {
         int[] arr = {1,6,11,5};
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

//        Solution1 --> Direct using TargetSumSubsest problem
//        Target Sum Code
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int j = 0; j < sum+1; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }

//        Code for this problem
//        int i = sum/2;
        int s1 = 0;
        for (int i = sum/2; i >=0 ; i--) {
            if (dp[n][i]) {
                s1 = i;
                break;
            }
        }
        System.out.println(sum-(2*s1));


//        Solution2 --> Writing different code (Recursive)
        System.out.println(partitionMinSum(arr,n,sum,0));

//        Solution3 --> Converting recursive code to Tabulation (Bottom-up)
        boolean[][] dp3 = new boolean[n+1][sum+1];
        for (int i = 0; i < n+1; i++) {
            dp3[i][0] = true;
        }
    }

    private static int partitionMinSum(int[] arr, int n, int sum, int currSum) {
        if (n==0) {
            return Math.abs(2*currSum - sum);
        }
        return Math.min(partitionMinSum(arr,n-1,sum,currSum+arr[n-1]),partitionMinSum(arr,n-1,sum,currSum));
    }
}
