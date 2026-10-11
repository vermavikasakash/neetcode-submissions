class Solution {
    int m;
    int n;
    public int numIslands(char[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    bfs(i, j, grid);
                    grid[i][j] = '#';
                }
            }
        }
        return ans;
    }

    int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    void bfs(int x, int y, char[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] d : dir) {
                int nx = curr[0] + d[0];
                int ny = curr[1] + d[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != '1') {
                    continue;
                }

                grid[nx][ny] = '#';
                queue.offer(new int[] {nx, ny});
            }
        }
    }
}
