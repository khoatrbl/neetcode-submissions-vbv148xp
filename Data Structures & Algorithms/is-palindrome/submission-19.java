class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {
            if (!valid(s.charAt(r))) {
                r--;
                continue;
            }

            if (!valid(s.charAt(l))) {
                l++;
                continue;
            }

            if (s.toLowerCase().charAt(l) != s.toLowerCase().charAt(r)) {
                return false;
            }
            r--;
            l++;
        }
        return true;
    }

    private boolean valid(char c) {
        return c <= 'z' && c >= 'a'
            || c <= 'Z' && c >= 'A'
            || c <= '9' && c >= '0';
    }
}
