class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    queue.offer(new int[] {i, j});
            }
        }

        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            
            int[] curr = queue.poll();

            int r = curr[0], c = curr[1];

            for (int[] d : dir) {
                int nx = r + d[0];
                int ny = c + d[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == -1
                    || grid[nx][ny] == 0) {
                    continue;
                }
                int prev = 1 + grid[r][c];
               
                if(prev < grid[nx][ny]) queue.offer(new int[] {nx,ny});
                 grid[nx][ny] = Math.min(prev, grid[nx][ny]);
            }
        }
    }
}
