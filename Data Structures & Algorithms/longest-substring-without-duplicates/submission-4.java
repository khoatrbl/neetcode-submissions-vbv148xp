class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int l = 0;
        
        int result = 0;

        Set<Character> seen = new HashSet<>();

        for (int r = 0; r < s.length(); r++) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            result = Math.max(result, r - l + 1);
        }

        return result;

        

    }
}   

