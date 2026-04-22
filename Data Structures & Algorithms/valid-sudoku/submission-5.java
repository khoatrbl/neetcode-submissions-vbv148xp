class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char currentVal = board[r][c];

                if (currentVal == '.') {
                    continue;
                }

                String squareKey = r / 3 + " , " + c / 3;

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(currentVal)
                    || cols.computeIfAbsent(c, k -> new HashSet<>()).contains(currentVal)
                    || squares.computeIfAbsent(squareKey, k -> new HashSet<>())
                        .contains(currentVal)) {
                    return false;
                }

                rows.get(r).add(currentVal);
                cols.get(c).add(currentVal);
                squares.get(squareKey).add(currentVal);
            }
        }

        return true;
    }
}