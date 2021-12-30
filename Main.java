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

    public static void prompt(Scanner sc, String[][] board, int[] userPair) {
        System.out.print("Enter X,Y coordinates for your move: ");
        String pair = sc.nextLine();
        userPair[0] = Integer.parseInt(pair.substring(0, 1)) - 1;
        userPair[1] = Integer.parseInt(pair.substring(2)) - 1;
    }

    

    public static void placeX(String[][] input, boolean notPlaced, int x, int y) {
        if (notPlaced) {
            input[x][y] = " X ";
        }
    }

    // further edit for computer output
    public static void placeO(String[][] board, String[][] input) {
        for (int r = 0; r < input.length; r += 2) {
            for (int c = 0; c < input[r].length; c += 2) {
                if (input[r][c].equals("   ")) {
                    input[r][c] = " O ";
                    return;
                }
            }
        }
    }

    public static boolean notPlaced(String[][] input, int x, int y) {
        if (input[x][y].equals(" X ") || input[x][y].equals(" O ")) {
            return false;
        }
        return true;
    }

    

}
