class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int speed = (low + high) >> 1;

            if (canEat(speed, h, piles)) {
                ans = Math.min(ans, speed);
                high = speed - 1;
            } else {
                low = speed + 1;
            }
        }
        return ans;
    }
    boolean canEat(int speed, int h, int[] piles) {
        int req = 0;
        for (int pile : piles) {
            req += (int) Math.ceil((double)pile / speed);
            
            if (req > h) break;
        }

        return req <= h;
    }
}
