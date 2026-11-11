class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorr = n;
        for (int i = 0; i < n; i++) {
            int curXor = i ^ nums[i];

            xorr = xorr ^ curXor;
        }
        return xorr;
    }
}
