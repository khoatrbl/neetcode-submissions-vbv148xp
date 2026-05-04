class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = piles[0];
        int res = 0;

        for (int pile : piles) {
            r = Math.max(pile, r);
        }

        while (l <= r) {
            int speed = (l + r) / 2;
            int time = 0;

            for (int pile : piles) {
                time += (int)Math.ceil((double) pile / speed);
            }

            if (time <= h) {
                res = speed;
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }

        return res;
    }
}
