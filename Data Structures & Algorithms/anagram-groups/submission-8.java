class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }

            String countKey = Arrays.toString(count);

            res.computeIfAbsent(countKey, k -> new ArrayList<>());
            res.get(countKey).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
