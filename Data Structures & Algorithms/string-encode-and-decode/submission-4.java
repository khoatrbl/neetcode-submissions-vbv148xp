class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();

        for (String s : strs) {
            encode.append(s.length()).append("#").append(s);
        }

        return encode.toString();
    }

    public List<String> decode(String str) {
        if (str.length() == 0) {
            return new ArrayList<>();
        }

        List<String> decode = new ArrayList<>();

        // 5#Hello5#World
        int i = 0;
        while (i < str.length()) {
            int j = i;

            while (str.charAt(j) != '#') {
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));

            i = j + 1;
            j = i + length;

            decode.add(str.substring(i, j));
            i = j;
        }

        return decode;
    }
}
