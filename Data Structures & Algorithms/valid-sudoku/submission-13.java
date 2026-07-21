class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                char current = board[r][c];

                if (current == '.') {
                    continue;
                }

                String sqrK = r/3 + "," + c/3;

                if (row.computeIfAbsent(r, k -> new HashSet<>()).contains(current)
                ||  col.computeIfAbsent(c, k -> new HashSet<>()).contains(current)
                ||  square.computeIfAbsent(sqrK, k -> new HashSet<>()).contains(current)) {

                    return false;
                }

                row.get(r).add(current);
                col.get(c).add(current);
                square.get(sqrK).add(current);

            }
        }

        return true;
    }
}
