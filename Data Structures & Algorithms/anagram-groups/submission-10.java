class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String str : strs) {
            char[] freq = new char[26];

            for (int i = 0; i < str.length(); i++) {
                freq[str.charAt(i) - 'a']++;
            }

            String freqKey = Arrays.toString(freq);

            res.computeIfAbsent(freqKey, k -> new ArrayList<>());
            res.get(freqKey).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
