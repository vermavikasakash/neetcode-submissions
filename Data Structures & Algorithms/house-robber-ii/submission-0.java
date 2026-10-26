class Solution {
    int[] dp;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        dp = new int[n];
        Arrays.fill(dp, -1);
        int option1 = solve(n - 2, nums, 0);

        dp = new int[n];
        Arrays.fill(dp, -1);
        int option2 = solve(n - 1, nums, 1);

        return Math.max(option1, option2);
    }

    int solve(int idx, int[] nums, int start) {
        if (idx < start) return 0;
        if (idx == start) return nums[start];

        if (dp[idx] != -1) return dp[idx];

        int option1 = nums[idx] + solve(idx - 2, nums, start);
        int option2 = solve(idx - 1, nums, start);

        return dp[idx] = Math.max(option1, option2);
    }
}