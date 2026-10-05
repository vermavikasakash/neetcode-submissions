class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int largestSreak = 0;

        for (int num : set) {

            if (!set.contains(num - 1)) { // start of sequence
                int currStreak = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currStreak++;
                }
                largestSreak = Math.max(largestSreak,currStreak);
            }
        }

        return largestSreak;
    }
}
