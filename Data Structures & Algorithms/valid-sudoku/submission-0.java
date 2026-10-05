class Solution {
    public boolean isValidSudoku(char[][] board) {
      
        List<Set<Character>> rows = new ArrayList<>(9);
        List<Set<Character>> cols = new ArrayList<>(9);
        List<Set<Character>> boxes = new ArrayList<>(9);

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                char val = board[i][j];
                if (val == '.') continue;

                int boxId = (i / 3) * 3 + (j / 3);

                if (rows.get(i).contains(val)) return false;
                if (cols.get(j).contains(val)) return false;
                if (boxes.get(boxId).contains(val)) return false;

                rows.get(i).add(val);
                cols.get(j).add(val);
                boxes.get(boxId).add(val);
            }
        }
        return true;
    }
}
