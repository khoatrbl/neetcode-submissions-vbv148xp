class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // first sort the array
        // the sorted nature of the array will allow us to skip duplicates
        // at each triplet, calculate the sum 
        // if sum > 0, we need to add a smaller number -> decrease r
        // if sum < 0, we need to add a larger number -> increase l
        // if we find duplicates, we skip it (increase/decrease the pointers) until we find a new number

        // [-4, -1, -1, 0, 1, 2]
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                // if nums[i] > 0, as the array is sorted, the remainding array will > 0
                // therefore, it's impossible to add
                // so we just break

                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++; 
                    r--;

                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                    }
                }
            }
        }

        return result;

    }
}
