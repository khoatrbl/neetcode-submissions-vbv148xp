class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] countS1 = new int[26];
        int[] countS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            countS1[s1.charAt(i) - 'a']++;
            countS2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < countS1.length; i++) {
            if (countS1[i] == countS2[i]) {
                matches++;
            }
        }

        int l = 0;
        for (int r = s1.length(); r < s2.length(); r++) {
            if (matches == 26) {
                return true;
            }

            int index = s2.charAt(r) - 'a';
            countS2[index]++;

            if (countS1[index] == countS2[index]) {
                matches++;
            } else if (countS1[index] + 1 == countS2[index]) {
                matches--;
            }

            index = s2.charAt(l) - 'a';
            countS2[index]--;

            if (countS1[index] == countS2[index]) {
                matches++;
            } else if (countS1[index] - 1 == countS2[index]) {
                matches--;
            }

            l++;
        }
        

        return matches == 26;


    }
}
