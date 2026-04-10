class Solution {
    public int longestConsecutive(int[] nums) {
        // O(nlogn)
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        int res = 0;
        int current = nums[0];
        int streak = 0;
        int i = 0;

        while (i < nums.length) {
            
            if (nums[i] != current) {
                current = nums[i];
                streak = 0;
            }

            while (i < nums.length && nums[i] == current) {
                i++;
            }

            streak++;
            current++;

            res = Math.max(res, streak);


        }



        return res;

    }
}
