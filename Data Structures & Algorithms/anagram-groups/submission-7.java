class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        

        for (String s : strs) {
            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String countKey = Arrays.toString(count);

            result.computeIfAbsent(countKey, k -> new ArrayList<>());
            result.get(countKey).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
