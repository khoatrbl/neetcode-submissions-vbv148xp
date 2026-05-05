class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;

        // suffix = 48
        // [1, 1, 2, 8]
        // [48, 24, 12, 8]

        int prefix = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            prefix *= nums[i];
            res[i + 1] = prefix;
        }

        int suffix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = suffix * res[i];
            suffix *= nums[i];
        }

        return res;

    }
}  
