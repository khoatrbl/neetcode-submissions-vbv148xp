public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }

        int r = s1.length() - 1;
        int l = 0;

        while (r < s2.length()) {
            int[] subStringFreq = new int[26];

            for (int i = l; i <= r; i++) {
                char c = s2.charAt(i);

                subStringFreq[c - 'a']++;
            }

            System.out.println("L: " + l);
            System.out.println("Freqs:" + Arrays.toString(freq));
            System.out.println("SubFreqs:" + Arrays.toString(subStringFreq));
            System.out.println("Res:" + (freq.equals(subStringFreq)));

            if (Arrays.equals(freq, subStringFreq)) {
                return true;
            }

            l++;
            r++;
        }

        return false;
    }
}