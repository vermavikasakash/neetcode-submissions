class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        int freshOranges = 0;

        // 1. Find all initial rotten oranges and count fresh ones
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j, 0}); // {row, col, time}
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        // If there are no fresh oranges to begin with, 0 minutes have passed
        if (freshOranges == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 2. Run a single Multisource BFS
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int t = cur[2];
            minutes = t; // Track the latest time reached

            for (int[] d : directions) {
                int nx = x + d[0];
                int ny = y + d[1];

                // If the neighbor is not within bounds and is not a fresh orange
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != 1) {
                    continue;
                }
                grid[nx][ny] = 2; // Turn it rotten
                freshOranges--; // Decrease fresh count
                queue.offer(new int[] {nx, ny, t + 1});
            }
        }

        // 3. If fresh oranges still remain, it's impossible to rot all of them
        return freshOranges == 0 ? minutes : -1;
    }
}
