class Solution {
    int[][] dp, grid;
    int m, n;

    public int longestIncreasingPath(int[][] matrix) {
        grid = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[m][n];
        int ans = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int res = solve(i, j);
                ans = Math.max(ans, res);
            }
        }
        return ans;
    }
    int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    int solve(int r, int c) {
        int max = 1;
         if(dp[r][c] != 0) return dp[r][c];

        for (int[] d : dir) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                continue;

            if (grid[nr][nc] > grid[r][c]) {
                max = Math.max(max, 1 + solve(nr, nc));
            }
        }

        return dp[r][c] = max;
    }
}
