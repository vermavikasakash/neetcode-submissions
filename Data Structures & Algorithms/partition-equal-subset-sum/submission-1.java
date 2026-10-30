class Solution {
    int target, n;
    int[] nums;
    Boolean[][] dp;

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        n = nums.length;
        target = Arrays.stream(nums).sum();

        if (target % 2 == 1) return false;

        target = target / 2;
        dp = new Boolean[n][target + 1];

        return solve(0, 0);
    }

    boolean solve(int idx, int curSum) {
        if (idx >= n || curSum > target) return false;

        if (curSum == target) return true;
        if (dp[idx][curSum] != null) return dp[idx][curSum];

        boolean take = solve(idx + 1, curSum + nums[idx]);
        boolean skip = solve(idx + 1, curSum);

        return dp[idx][curSum] = take || skip;
    }
}
