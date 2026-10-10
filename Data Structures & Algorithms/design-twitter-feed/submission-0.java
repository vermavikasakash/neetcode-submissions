record Pair(int tweetId, int time) {}

class Twitter {
    int cnt = 0;

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Pair>> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        cnt++;
        if (!tweetMap.containsKey(userId)) tweetMap.put(userId, new ArrayList<>()); 
        tweetMap.get(userId).add(new Pair(tweetId, cnt));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();

        // Entry: {tweetId, time, followeeId, index}
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));

        if (!followMap.containsKey(userId)) followMap.put(userId, new HashSet<>());
        followMap.get(userId).add(userId); // Include the user's own tweets

        for (int followeeId : followMap.get(userId)) {

            if (tweetMap.containsKey(followeeId)) {
                List<Pair> tweets = tweetMap.get(followeeId);
                int index = tweets.size() - 1;
                Pair tweet = tweets.get(index);

                maxHeap.offer(new int[]{ tweet.tweetId(), tweet.time(), followeeId, index });
            }
        }

        while (!maxHeap.isEmpty() && res.size() < 10) {
            int[] curr = maxHeap.poll();

            res.add(curr[0]);

            int followeeId = curr[2];
            int index = curr[3];

            // Add the next older tweet from this user
            if (index > 0) {
                Pair tweet = tweetMap.get(followeeId).get(index - 1);
                maxHeap.offer(new int[]{ tweet.tweetId(), tweet.time(), followeeId, index - 1 });
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId)  return;
        if (!followMap.containsKey(followerId)) followMap.put(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) followMap.get(followerId).remove(followeeId);   
    }
}