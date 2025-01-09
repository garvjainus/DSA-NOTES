class Solution {
    String w;
    char[][] b;

    public boolean exist(char[][] board, String word) {
        b = board;
        w = word;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (backtrack(r, c, "")) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int r, int c, String res) {
        if (res.equals(w)) {
            return true;
        }

        if (r < 0 || r >= b.length || c < 0 || c >= b[0].length || b[r][c] == '#' || b[r][c] != w.charAt(res.length())) { //you are validating whether the current cell in the board matches the next character to be added to res
            return false;
        }

        res += b[r][c];
        char temp = b[r][c];
        b[r][c] = '#';

        boolean found = false;
        if (backtrack(r + 1, c, res)) { 
            found = true;
        } else if (backtrack(r - 1, c, res)) { 
            found = true;
        } else if (backtrack(r, c + 1, res)) { 
            found = true;
        } else if (backtrack(r, c - 1, res)) {
            found = true;
        }

        b[r][c] = temp; //we set it back so that it isnt permanently # if we start the serach from another cell

        return found;
    }
}
