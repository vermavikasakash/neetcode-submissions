class Solution {
    int[][] dp;
    int n;
    int nums[];
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        this.nums = nums;
        dp = new int[n][n + 1];

        for (int[] row : dp) Arrays.fill(row, -1);
        
        return solve(n - 1, n);
    }

    int solve(int idx, int prevIdx) {
        if (idx < 0) return 0;

        if (dp[idx][prevIdx] != -1) return dp[idx][prevIdx];
        

        int take = 0;

        if (prevIdx == n || nums[idx] < nums[prevIdx]) {
            take = 1 + solve(idx - 1, idx);
        }

        int skip = solve(idx - 1, prevIdx);

        return dp[idx][prevIdx] = Math.max(take, skip);
    }
}