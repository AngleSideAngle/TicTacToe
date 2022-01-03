public class Game {
    private Board board;
    private Human human;
    private Opponent opponent;
    private boolean playerFirst;

    public Game(boolean playerGoesFirst) {
        board = new Board(3);
        human = new Human();
        opponent = new Opponent();
        playerFirst = playerGoesFirst;
    }

    public boolean round() {
        if (playerFirst) {
            printBoard();
            human.move(board);
            if (checkWin(board.getBoard())) {
                System.out.println("You win!");
                return false;
            }
        } else {
            opponent.move(board);
            if (checkWin(board.getBoard())) {
                System.out.println("You loose, better luck next time.");
                return false;
            }
        }

        // checkTie is here because in a board with odd number of tiles, it will always be the first player who ties
        if (checkTie(board.getBoard())) {
            System.out.println("It's a tie!");
            return false;
        }

        if (playerFirst) {
            opponent.move(board);
            if (checkWin(board.getBoard())) {
                System.out.println("You loose, better luck next time.");
                return false;
            }
        } else {
            printBoard();
            human.move(board);
            if (checkWin(board.getBoard())) {
                System.out.println("You win!");
                return false;
            }
        }
        
        return true;
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

    public boolean checkWin(char[][] board) {
        for (int i = 0; i < board.length; i++)
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2] // rows
                    || board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) // columns
                return true;

        // diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]
                || board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return true;

        return false;
    }

    public boolean checkTie(char[][] board) {
        for (char[] row : board)
            for (char ch : row)
                if (ch == ' ')
                    return false;
        return true;
    }
}
