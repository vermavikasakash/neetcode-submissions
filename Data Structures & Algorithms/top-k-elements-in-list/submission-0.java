class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Pair> pq = 
        new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();

            pq.offer(new Pair(key, value));
        }
        int[] ans = new int[k];
        int idx = 0;
        while (k > 0) {
            ans[idx++] = pq.poll().key;  
            k--;
        }
        return ans;
    }
    private class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
