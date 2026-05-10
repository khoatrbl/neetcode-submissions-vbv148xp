class Solution {
    public String minWindow(String s, String t) {
        if (t.length() == 0) {
            return "";
        }

        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int[] res = {-1, -1};
        int minLength = s.length() + 1;
        int need = tCount.size();
        int have = 0;

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (tCount.containsKey(c) && tCount.get(c) == window.get(c)) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < minLength) {
                    minLength = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftC = s.charAt(l);
                window.put(leftC, window.get(leftC) - 1);

                if (tCount.containsKey(leftC) && window.get(leftC) < tCount.get(leftC)) {
                    have--;
                }
                l++;
            }
        }
        return minLength == s.length() + 1 ? "" : s.substring(res[0], res[1] + 1);

    }
}
