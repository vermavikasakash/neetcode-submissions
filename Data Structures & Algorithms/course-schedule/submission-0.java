class Solution {
    List<Integer>[] adj;
    int[] state;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList[numCourses];
        state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0 && dfs(i) == false) {
                return false;
            }
        }

        return true;
    }

    boolean dfs(int curr) {
        if (state[curr] == 1) return false; // cycle
        if (state[curr] == 2) return true; // already completed

        state[curr] = 1;

        for (int nei : adj[curr]) {
            if (!dfs(nei)) return false;
        }

        state[curr] = 2;
        return true;
    }
}