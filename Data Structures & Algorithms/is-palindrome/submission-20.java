class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            if (!valid(s.charAt(l))) {
                l++;
                continue;
            }

            if (!valid(s.charAt(r))) {
                r--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

    private boolean valid(char c) {
        return 'a' <= c && 'z' >= c 
            || 'A' <= c && 'Z' >= c 
            || '0' <= c && '9' >= c;
    }
}
