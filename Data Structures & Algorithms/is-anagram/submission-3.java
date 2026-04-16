class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        Arrays.sort(sChars);
        String sortedS = Arrays.toString(sChars);

        char[] tChars = t.toCharArray();
        Arrays.sort(tChars);
        String sortedT = Arrays.toString(tChars);

        return sortedS.equals(sortedT);
    }
}
