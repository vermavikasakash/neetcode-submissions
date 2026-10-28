class Solution {
    int n;
    String str;
    int[] dp;
    public int numDecodings(String s) {
        n = s.length();
        str = s;
        dp = new int[n];
        Arrays.fill(dp,-1);

        return solve(0);
    }
    int solve(int idx) {
        if (idx == n) return 1;
        if (str.charAt(idx) == '0' || idx > n) return 0;
        if(dp[idx] != -1) return dp[idx];

        int way1 = solve(idx + 1);
        int way2 = 0;
        if (idx + 2 <= str.length()) {
            int num = Integer.parseInt(str.substring(idx, idx + 2));
            if (num >= 10 && num <= 26) {
                way2 = solve(idx + 2);
            }
        }

        return dp[idx] = way1 + way2;
    }
}
