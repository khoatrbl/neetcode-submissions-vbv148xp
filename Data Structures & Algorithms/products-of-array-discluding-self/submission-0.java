class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Bruteforce

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                
                product *= nums[j];

            }

            res[i] = product;
        }

        return res;
    }
}  
