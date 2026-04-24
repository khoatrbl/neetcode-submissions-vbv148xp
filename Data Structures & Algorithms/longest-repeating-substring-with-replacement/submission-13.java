class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0;

        Map<Character, Integer> count = new HashMap<>();
        int maxF = 0;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(count.get(s.charAt(r)), maxF);

            while ((r - l + 1) - maxF > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
