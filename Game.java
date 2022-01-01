public class Game {
    private Board board;
    private Human human;
    private Opponent opponent;

    public Game() {
        board = new Board(3);
        human = new Human();
        opponent = new Opponent();
    }

    public void round() {
        printBoard();
        human.move(board);
        opponent.move(board);   
    }

    public void printBoard() {
        char[][] places = board.getBoard();
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places.length; j++) {
                System.out.print(" " + places[i][j] + " ");
                if (j != places.length - 1)
                    System.out.print("|");
            }
            System.out.println();
            if (i != places.length - 1) {
                for (int j = 0; j < places.length; j++) {
                    System.out.print("---");
                    if (j != places.length - 1)
                        System.out.print("|");
                }
                System.out.println();
            }
        }
    } 

    public boolean checkWin(String[][] board, String letter) {
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
}
