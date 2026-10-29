class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        Set<String> set = new HashSet<>(wordDict);

        dp[0] = true; // empty string

        for (int i = 0; i < n; i++) {
            if (dp[i] != true) continue;    

            for (int j = i; j < n; j++) {

                String str = s.substring(i, j + 1);
                if (set.contains(str)) dp[j + 1] = true;   
            }
        }

        return dp[n];
    }
}