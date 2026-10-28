class Solution {
    int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);

        int ans = solve(amount, coins);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    int solve(int target, int[] coins) {
        if (target == 0) return 0;
        if (target < 0) return Integer.MAX_VALUE;

        if (dp[target] != -1) return dp[target];

        int change = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = solve(target - coin, coins);

            if (result != Integer.MAX_VALUE) {
                change = Math.min(change, 1 + result);
            }
        }

        return dp[target] = change;
    }
}