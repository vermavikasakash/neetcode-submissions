class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);

        for (int i = 1; i < n; i++) {
            int[] conflict = ans.getLast();

            if (conflict[1] >= intervals[i][0]) {
                conflict[0] = Math.min(conflict[0], intervals[i][0]);
                conflict[1] = Math.max(conflict[1], intervals[i][1]);
                ans.removeLast();
                ans.add(conflict);
            } else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
