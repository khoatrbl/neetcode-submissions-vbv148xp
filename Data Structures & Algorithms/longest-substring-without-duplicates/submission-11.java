class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0;

        int l = 0;
        Set<Character> seen = new HashSet<>();
        for (int r = l; r < s.length(); r++) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));

            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }
}
