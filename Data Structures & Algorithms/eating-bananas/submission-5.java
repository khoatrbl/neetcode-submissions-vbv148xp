class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // O(logn)

        int left = 1;
        int right = 0;

        for (int num : piles) {
            right = Math.max(right, num);
        }

        int res = 0;
        while (left <= right) {
            long time = 0;

            int mid = left + (right - left) / 2;
            
            for (int pile : piles) {
                time += (int)Math.ceil((double) pile / mid);
            } 

            if (time <= h) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
