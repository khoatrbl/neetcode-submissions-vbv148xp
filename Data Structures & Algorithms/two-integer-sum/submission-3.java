class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int numberToFind = target - nums[i];

            if (seen.containsKey(numberToFind)) {
                return new int[]{seen.get(numberToFind), i};
            }

            seen.put(nums[i], i);
        }

        return new int[2];
    }
}
