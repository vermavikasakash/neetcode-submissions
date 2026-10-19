class Solution {
    Set<Integer> visited;
    List<Integer>[] adj;

    public int countComponents(int n, int[][] edges) {
        visited = new HashSet<>();
        adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                ans++;
                bfs(i);
            }
        }
        return ans;
    }
    void bfs(int i) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(i);
        visited.add(i);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int nei : adj[curr]) {
                if (!visited.contains(nei)) {
                    q.offer(nei);
                    visited.add(nei);
                }
            }
        }
    }
}
