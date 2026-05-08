class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();

        for (String s : strs) {
            encode.append(s.length()).append("#").append(s);
        }

        return encode.toString();
    }

    public List<String> decode(String str) {
        if (str.equals("")) {
            return new ArrayList<>();
        }
        List<String> decode = new ArrayList<>();

        // 5#hello5#world

        int l = 0;
        while (l < str.length()) {
            int r = l;
            while (str.charAt(r) != '#') {
                r++;
            }

            int length = Integer.parseInt(str.substring(l, r));
            l = r + 1;
            r += length + 1;

            decode.add(str.substring(l, r));
            l = r;
        }

        return decode;
    }
}
