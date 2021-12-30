import java.util.Scanner;

class Main {
    private static String[][] board = new String[5][5];
    private static String[][] input = new String[3][3];
    private static int[] userPair = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = "   "; // one " " is equal to "-" length
                if (j % 2 != 0) {
                    board[i][j] = "|";
                } else if (i % 2 != 0 && j % 2 == 0) {
                    board[i][j] = "---";
                }
            }
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                input[i][j] = "   ";
            }
        }
        // issue with entering same coordinates
        printBoard(board, input);
        while (won(board, " X ") != true) {
            prompt(sc, board, userPair);
            placeX(input, notPlaced(input, userPair[0], userPair[1]), userPair[0], userPair[1]);
            // placeO(board, input);
            printBoard(board, input);
        }

        if (won(board, " X ")) {
            System.out.println("You won!");
        }

    }

}
