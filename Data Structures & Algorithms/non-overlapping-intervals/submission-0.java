class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        int ans = 0;
        int[] conflict = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (conflict[1] > intervals[i][0]) {
                ans++;
                conflict[1] = Math.min(conflict[1], intervals[i][1]);
            } else {
                conflict = intervals[i];
            }
        }

        return ans;
    }
}