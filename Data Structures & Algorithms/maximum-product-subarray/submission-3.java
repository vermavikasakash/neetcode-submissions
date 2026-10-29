class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = nums[0];
        suffix[n - 1] = nums[n - 1];
        int ans = prefix[0];

        for (int i = 1; i < n; i++) {
            int prevPrefix = prefix[i - 1] == 0 ? 1 : prefix[i - 1];
            prefix[i] = nums[i] * prevPrefix;

            int prevSuffix = suffix[n - i] == 0 ? 1 : suffix[n - i];
            suffix[n - i - 1] = nums[n - i - 1] * prevSuffix;
        }
        // System.out.println("prefix : " + Arrays.toString(prefix));
        // System.out.println("suffix : " + Arrays.toString(suffix));
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(prefix[i], suffix[i]));
        }
        return ans;
    }
}
