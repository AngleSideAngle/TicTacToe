public class Opponent extends Player {
    private char opp;

    public Opponent() {
        super('O');
        opp = 'X';
    }

    public void move(Board board) {
        while (true) {
            // offensive
            int[] coords = findNextMove(board.getBoard(), getSign());
            if (coords[0] == -1)
                // defensive
                coords = findNextMove(board.getBoard(), opp);
            if (coords[0] == -1)
                // random
                coords = findRandomMove(board.getBoard());

            // attempts to place at points
            if (move(board, coords[0], coords[1]))
                break;
        }
    }
    
    private int[] findNextMove(char[][] board, char ch) {
        int[] coords = {-1, -1};
        for (int i = 0; i < board.length; i++) {
            // row
            char[] row = board[i];
            if (countChar(row, ch) == 2 && firstEmpty(row) != -1) {
                coords[0] = i;
                coords[1] = firstEmpty(row);
                break;
            }

            // column
            char[] column = getColumn(board, i);
            if (countChar(column, ch) == 2 && firstEmpty(column) != -1) {
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
        if (countChar(diagonal, ch) == 2 && firstEmpty(diagonal) != -1) {
            coords[0] = firstEmpty(diagonal);
            coords[1] = firstEmpty(diagonal);
        }

        // top right to bottom left
        if (countChar(reverse, ch) == 2 && firstEmpty(reverse) != -1) {
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

    // deprecated
    private int[] findRandomMove(char[][] board) {
        int[] coords = new int[2];
        coords[0] = (int) (Math.random() * 4);
        coords[1] = (int) (Math.random() * 4);
        return coords;
    }
}