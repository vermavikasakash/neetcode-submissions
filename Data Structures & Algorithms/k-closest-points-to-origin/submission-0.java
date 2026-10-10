record Pair(int x, int y, int dis) {}
class Solution {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> maxHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(b.dis(), a.dis()));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;

            maxHeap.offer(new Pair(x, y, dist));
            if (maxHeap.size() > k) maxHeap.poll();     
        }

        int[][] res = new int[k][2];
        int i = 0;

        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            res[i][0] = pair.x();
            res[i][1] = pair.y();
            i++;
        }

        return res;
    }
}