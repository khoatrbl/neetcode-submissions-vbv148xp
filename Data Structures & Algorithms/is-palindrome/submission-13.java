class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (!isAlphaNumeric(s.charAt(left))) {
                left++;
                continue;
            }

            if (!isAlphaNumeric(s.charAt(right))) {
                right--;
                continue;
            }

            if (s.toLowerCase().charAt(left) != s.toLowerCase().charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return c >= 'a' && c <= 'z' 
            || c >= 'A' && c <= 'Z' 
            || c >= '0' && c <= '9';
    }
}
