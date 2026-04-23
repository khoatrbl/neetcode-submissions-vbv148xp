class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count occurrence of each number
        // an array of size nums.length + 1 to store the List<Integer> 
        // in the index that corresponds to the frequency.
        // then, traverse the frequency array from the end, get K elements 
        // then returns

        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int num : count.keySet()) {
            freq[count.get(num)].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i >= 0 && index < k; i--) {
            for (int num : freq[i]) {
                res[index++] = num;

                if (index == k) {
                    return res;
                }
            }
        }

        return res;
    }
}
