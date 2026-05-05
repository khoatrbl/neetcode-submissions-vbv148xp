class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freqs = new List[nums.length + 1];
        for (int i = 0; i < freqs.length; i++) {
            freqs[i] = new ArrayList<>();
        }

        for (int num : count.keySet()) {
            freqs[count.get(num)].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freqs.length - 1; index < k && i >= 0; i--) {
            for (int num : freqs[i]) {
                res[index++] = num;

                if (index == k) {
                    return res;
                }
            }
        }

        return res;
        
    }
}
