public class Board {
    private char[][] board;

    public Board(int x, int y) {
        board = new char[x][y];
    }

    public static boolean checkWin(String[][] board, String letter) {
        int count = 0;
        for (int i = 0; i < board.length; i += 2) {
            for (int j = 0; j < board[i].length; j += 2) {
                if (board[i][j].equals(letter)) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
            count = 0;
        }
        for (int i = 0; i < board.length; i += 2) {
            for (int j = 0; j < board[i].length; j += 2) {
                if (board[j][i].equals(letter)) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
            count = 0;
        }

        for (int i = 0; i < board.length; i += 2) {
            for (int j = i; j <= i; j++) {
                if (board[i][j].equals(letter)) {
                    count++;
                }
            }
        }
        if (count == 3) {
            return true;
        }
        count = 0;
        for (int i = board.length - 1; i >= 0; i -= 2) {
            for (int j = 4 - i; j <= 4 - i; j++) {
                if (board[i][j].equals(letter)) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public char[][] getBoard(String[][] board, String[][] input) {
        int r = 0;
        int c = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j % 2 == 0 && i % 2 == 0) {
                    board[i][j] = input[r][c];
                    c++;
                }
                System.out.print(board[i][j]);
            }
            c = 0;
            if (i % 2 == 0) {
                r++;
            }
            System.out.println();
        }
    }
}
