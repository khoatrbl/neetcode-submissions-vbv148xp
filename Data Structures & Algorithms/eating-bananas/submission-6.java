class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // First intuition is to try every k value,
        // until we find the first k value that after computing the time it takes to eat,
        // is less than the value of h

        // to compute the time eat, we take the pile / k and round the value up.

        // however, because we know that as the value of k increases, 
        // it would take less time to eat all the bananas
        // and the problem states that Koko can only eat 1 pile in 1 hour,
        // cannot move to the next pile
        // this means that the value of k we need to find, 
        // should only be within the range of 1 - the max value of pile
        // because even if koko can eat 100 bananas/hour, 
        // he cannot move to the next pile within the same hour

        // we can perform a binary search on this search space
        // if the middle value, after calculation, is <= h
        // we can record this, and move on to find a smaller value of k (on the left)

        int l = 1;
        int r = 0;

        for (int pile : piles) {
            r = Math.max(r, pile);
        }

        int res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            
            int time = 0;

            for (int pile : piles) {
                time += (int)Math.ceil((double) pile / mid);
            }

            if (time <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
