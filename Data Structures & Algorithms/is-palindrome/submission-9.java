class Solution {
    public boolean isPalindrome(String s) {
        // two pointers solution
        // one at the start, one at the end, move until crossed
        // compare each pointer, ignore case and nonalphanumeric characters

        String convertedString = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        System.out.println(convertedString);

        if (convertedString.length() <= 0) {
            return true;
        }

        int left = 0;
        int right = convertedString.length() - 1;

        while (left <= right) {
            if (convertedString.charAt(left) != convertedString.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
