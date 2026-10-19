class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        List<Integer>[] adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        Set<Integer> visited = new HashSet<>();

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, -1});
        visited.add(0);

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int nei : adj[curr[0]]) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.offer(new int[] {nei, curr[0]});
                } else if (nei != curr[1]) return false;          
            }
        }

        return visited.size() == n;
    }
}