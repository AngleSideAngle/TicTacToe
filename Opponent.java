public class Opponent extends Player {
    private char opp;
    boolean goesFirst;
    int[] starting = {0, 0};

    public Opponent(boolean playerFirst) {
        super('O');
        opp = 'X';
        goesFirst = !playerFirst;
    }

    public void move(Board board) {
        for (int threshold = 2; threshold > 0; threshold--) {
            // offensive
            int[] coords = findNextMove(board.getBoard(), getSign(), threshold);
            // defensive
            if (coords[0] == -1)
                coords = findNextMove(board.getBoard(), opp, threshold);

            if (move(board, coords[0], coords[1]))
                return;
        }

        // tries a starting move
        if (goesFirst && move(board, starting[0], starting[1]))
            return;
                    
        // random
        while (true) {
            int[] coords = findRandomMove(board.getBoard());

            if (move(board, coords[0], coords[1]))
                return;
        }
    }
    
    private int[] findNextMove(char[][] board, char ch, int threshold) {
        int[] coords = {-1, -1};
        for (int i = 0; i < board.length; i++) {
            // row
            char[] row = board[i];
            if (countChar(row, ch) == threshold && firstEmpty(row) != -1) {
                coords[0] = i;
                coords[1] = firstEmpty(row);
                break;
            }

            // column
            char[] column = getColumn(board, i);
            if (countChar(column, ch) == threshold && firstEmpty(column) != -1) {
                coords[0] = firstEmpty(column);
                coords[1] = i;
            }
        }

        char[] diagonal = new char[board.length];
        char[] reverse = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            diagonal[i] = board[i][i];
            reverse[i] = board[i][board.length - 1 - i];
        }

        // top left to bottom right
        if (countChar(diagonal, ch) == threshold && firstEmpty(diagonal) != -1) {
            coords[0] = firstEmpty(diagonal);
            coords[1] = firstEmpty(diagonal);
        }

        // top right to bottom left
        if (countChar(reverse, ch) == threshold && firstEmpty(reverse) != -1) {
            coords[0] = firstEmpty(reverse);
            coords[1] = board.length - 1 - firstEmpty(reverse);
        }
        

        return coords;
    }

    private char[] getColumn(char[][] grid, int x) {
        char[] column = new char[grid.length];
        for (int i = 0; i < grid.length; i++)
            column[i] = grid[i][x];
        return column;
    }

    private int countChar(char[] arr, char ch) {
        int count = 0;
        for (char test: arr)
            if (test == ch)
                count++;
        return count;
    }

    private int firstEmpty(char[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == ' ')
                return i;
        return -1;
    }

    // last resort
    private int[] findRandomMove(char[][] board) {
        int[] coords = new int[2];
        coords[0] = (int) (Math.random() * 4);
        coords[1] = (int) (Math.random() * 4);
        return coords;
    }
}