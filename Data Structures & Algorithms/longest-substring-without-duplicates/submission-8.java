class Solution {
    public int lengthOfLongestSubstring(String s) {
        // A set to track all of the seen characters
        // Start with 2 pointers, left and right
        // traverse the string using the right pointer
        // if right pointer sees a new character, add it to the list
        // if not, remove the character at the left pointer up until the character removed was the char at right
        // calculate the length by r - l + 1;

        Set<Character> seen = new HashSet<>();
        int longest = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
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
