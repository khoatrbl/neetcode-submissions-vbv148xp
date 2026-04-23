class Solution {
    public int characterReplacement(String s, int k) {
        
        int res = 0;

        for (int l = 0; l < s.length(); l++) {
            Map<Character, Integer> count = new HashMap<>();
            int highestFreq = 0;
            
            for (int r = l; r < s.length(); r++) {
                count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);

                int windowLength = r - l + 1;
                highestFreq = Math.max(highestFreq, count.get(s.charAt(r)));

                if (windowLength - highestFreq <= k) {
                    res = Math.max(res, windowLength);
                } else {
                    break;
                }
            }
        }

        return res;
    }
}
