class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> ans = new ArrayList<>();

        for (int[] curr : intervals) {
            if (ans.isEmpty() || ans.getLast()[1] < curr[0]) {
                ans.add(curr);
            } else {
                int[] last = ans.getLast();
                last[1] = Math.max(last[1], curr[1]);
            }
        }

        return ans.toArray(new int[0][0]);
    }
}