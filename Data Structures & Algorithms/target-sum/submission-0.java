class Solution {
    int[] nums; int target, n;
    Map<String, Integer> dp = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.n = nums.length;

        return solve(0, 0);
    }

    int solve(int idx, int curSum) {
        if (idx == n)
            return curSum == target ? 1 : 0;

        String key = idx + "," + curSum;

        if (dp.containsKey(key)) return dp.get(key);

        int plus = solve(idx + 1, curSum + nums[idx]);
        int minus = solve(idx + 1, curSum - nums[idx]);

        dp.put(key, plus + minus);

        return dp.get(key);
    }
}