class Solution {
    int[] coins;
    Integer[][] dp;
    int n;
    public int change(int amount, int[] coins) {
        this.coins = coins;
        this.n = coins.length;
        this.dp = dp = new Integer[amount + 1][n];
        return solve(amount, 0);
    }
    int solve(int target, int start) {
        if (target == 0)
            return 1;
        if (target < 0 || start >= n)
            return 0;
            if(dp[target][start] != null) return dp[target][start];
        int ways = 0;
        for (int i = start; i < n; i++) {
            ways += solve(target - coins[i],  i);
        }
        return dp[target][start] = ways;
    }
}
