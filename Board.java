public class Board {
    private char[][] board;

    public Board(int size) {
        board = new char[size][size];
        for (int x = 0; x < board.length; x++)
            for (int y = 0; y < board.length; y++)
                board[x][y] = ' ';
    }

    // returns true if success, returns false if out of bounds or there already is a move in that point
    public boolean setPoint(char ch, int x, int y) {
        if (x >= board.length || y >= board.length || board[x][y] != ' ')
            return false;
        
        board[x][y] = ch;
        return true;
    }

    public char[][] getBoard() {
        return board;
    }
}
