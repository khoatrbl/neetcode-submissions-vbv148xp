class Solution {
    public int characterReplacement(String s, int k) {
        // this problem could be solved using the 2 pointers approach
        // we'll have a map that tracks the count of each character in the substring
        // and we'll use the most frequent character in the window
        
        // because we only need to find the longest length of the substring,
        // we can calculate this by taking r - l + 1

        // we can calculate the number of replacement needed if we take the window length
        // and subtract it with the maxFrequency of the substring. 
        // If it is <= k, its a valid window.
        // if not, we shrink the window, until we find another valid window

        int res = 0;
        Map<Character, Integer> count = new HashMap<>();

        int l = 0;
        int maxF = 0;
        for (int r = 0; r < s.length(); r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxF = Math.max(maxF, count.get(s.charAt(r)));

            while ((r - l + 1) - maxF > k) {
                count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                l++;
            }

            res = Math.max(maxF, r - l + 1);
        }

        return res;

        
    }
}
