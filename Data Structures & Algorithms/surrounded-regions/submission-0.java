class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Add border 'O' cells
        for (int i = 0; i < Math.max(m, n); i++) {
            if (i < n && board[0][i] == 'O') {
                board[0][i] = 'T';
                queue.offer(new int[] {0, i});
            }

            if (i < m && board[i][0] == 'O') {
                board[i][0] = 'T';
                queue.offer(new int[] {i, 0});
            }

            if (i < n && board[m - 1][i] == 'O') {
                board[m - 1][i] = 'T';
                queue.offer(new int[] {m - 1, i});
            }

            if (i < m && board[i][n - 1] == 'O') {
                board[i][n - 1] = 'T';
                queue.offer(new int[] {i, n - 1});
            }
        }

        // BFS from border cells
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1];

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O') {
                    board[nr][nc] = 'T';
                    queue.offer(new int[] {nr, nc});
                }
            }
        }

        // Restore safe cells; capture surrounded cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}