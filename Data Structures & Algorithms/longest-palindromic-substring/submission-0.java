class Solution {
    boolean[][] dp;

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new boolean[n][n];

        int start = 0, maxLen = 1;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;

            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }

        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;

                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                    if (len + 1 > maxLen) {
                        start = i;
                        maxLen = len + 1;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}