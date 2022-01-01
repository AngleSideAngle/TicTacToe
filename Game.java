public class Game {
    private Board board;
    private Human human;
    private Opponent opponent;

    public Game() {
        board = new Board(3);
        human = new Human();
        opponent = new Opponent();
    }

    public boolean round() {
        printBoard();
        human.move(board);
        if (checkWin(board.getBoard()) != ' ')
            return false;
        opponent.move(board);
        if (checkWin(board.getBoard()) != ' ')
            return false;
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

    public char checkWin(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            // rows
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2])
                return board[i][0];
            // columns
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i])
                return board[0][i];
        }
        // diagonals
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];
        return ' ';
    }
}
