package DP;

import java.util.Arrays;

public class MinCostClimbingStairs {

    // Recursion
    private static int dfs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        return cost[i] + Math.min(dfs(cost, i + 1),
                                  dfs(cost, i + 2));
    }

    public static int minCostClimbingStairsRecursion(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    // DP - Top Down
    static int[] memo;
    
    private static int dfs_dp(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = cost[i] + Math.min(dfs(cost, i + 1),
                                     dfs(cost, i + 2));
        return memo[i];
    }

    public static int minCostClimbingStairsDPTopDown(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(dfs_dp(cost, 0), dfs_dp(cost, 1));
    }

    // DP - Bottom Up
    public static int minCostClimbingStairsDPBottomUp(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1],
                             dp[i - 2] + cost[i - 2]);
        }
        
        return dp[n];
    }

    // DP Space Optimized
    public static int minCostClimbingStairs(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--) {
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }

    public static void main(String[] args) {

        int[] cost = {1,2,3,4,5,1};
        System.out.println(minCostClimbingStairsRecursion(cost));
        System.out.println(minCostClimbingStairsDPTopDown(cost));
        System.out.println(minCostClimbingStairsDPBottomUp(cost));
        System.out.println(minCostClimbingStairs(cost));
        
    }
}