class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int res = 0;
        int l = 1;
        int r = piles[0];

        for (int pile : piles) {
            r = Math.max(pile, r);
        }

        while (l <= r) {
            int speed = (l + r) / 2;
            int hours = 0;
            
            for (int pile : piles) {
                hours += (int)Math.ceil((double) pile / speed);
            }

            if (hours <= h) {
                res = speed;
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }

        return res;


    }
}
