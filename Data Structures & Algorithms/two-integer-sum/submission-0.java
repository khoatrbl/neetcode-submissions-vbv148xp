class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Map<Num, Index>
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int numToLookFor = target - nums[i];

            if (seen.containsKey(numToLookFor)) {
                return new int[]{seen.get(numToLookFor), i};
            }

            seen.put(nums[i], i);
        }

        return new int[2];
    }
}
