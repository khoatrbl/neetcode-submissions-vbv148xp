class Solution {
    public boolean isPalindrome(String s) {
        // two pointers

        if (s == null || s.length() == 0) {
            return true;
        }

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

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9');
    }
}
