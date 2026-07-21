class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : count.keySet()) {
            freq[count.get(num)].add(num);
        }

        int index = 0;
        int[] res = new int[k];

        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            List<Integer> currentFreq = freq[i];

            for (int num : currentFreq) {
                if (index == k) {
                    break;
                }

                res[index++] = num;
            }
            

        }

        return res;
    }
}
