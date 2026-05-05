class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                String squareKey = i / 3 + "," + j / 3;
                char character = board[i][j];

                if (character == '.') {
                    continue;
                }

                if (rows.computeIfAbsent(i, k -> new HashSet<>()).contains(character) ||
                    cols.computeIfAbsent(j, k -> new HashSet<>()).contains(character) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(character)) {
                        
                    return false;
                }

                rows.get(i).add(character);
                cols.get(j).add(character);
                squares.get(squareKey).add(character);
            }
        }

        return true;
    }
}
