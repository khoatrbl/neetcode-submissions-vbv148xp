class Solution {
    public int characterReplacement(String s, int k) {
        // O(n^2)

        int res = 0;

        for (int l = 0; l < s.length(); l++) {
            Map<Character, Integer> count = new HashMap<>();
            int maxF = 0;

            for (int r = l; r < s.length(); r++) {
                count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
                maxF = Math.max(maxF, count.get(s.charAt(r)));

                int length = r - l + 1;

                if (length - maxF <= k) {
                    res = Math.max(res, length);
                }
            }
        }
        return res;
    }
}
