class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            if (!isAlphaNumeric(s.charAt(l))) {
                l++;
                continue;
            }

            if (!isAlphaNumeric(s.charAt(r))) {
                r--;
                continue;
            }

            if (s.toLowerCase().charAt(l) != s.toLowerCase().charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return c >= 'a' && c <= 'z' 
            || c >= 'A' && c <= 'Z'
            || c >= '0' && c <= '9';
    }
}
