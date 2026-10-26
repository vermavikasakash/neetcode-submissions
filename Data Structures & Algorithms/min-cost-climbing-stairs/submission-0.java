class Solution {
    int n;
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        n = cost.length;
        dp = new int[n + 1];

        return Math.min(solve(0, cost), solve(1, cost));
    }
    int solve(int idx, int[] cost) {
        if (idx >= n) return 0;
        if (dp[idx] != 0) return dp[idx];
        int option1 = cost[idx] + solve(idx + 1, cost);
        int option2 = cost[idx] + solve(idx + 2, cost);

        return dp[idx] = Math.min(option1, option2);
    }
}
