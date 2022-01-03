import java.util.Scanner;

class Main {
    public static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        // main game loop
        do {
            boolean first = goFirst();
            Game game = new Game(first);
            while (game.round());
            game.printBoard();
        } while (playAgain());
        sc.close();
    }

    public static boolean playAgain() {
        System.out.print("Would you like to play again? Enter 1 for yes, 0 for no:\n> ");
        String answ = sc.nextLine();
        if (answ.equals("1"))
            return true;
        return false;
    }

    public static boolean goFirst() {
        System.out.print("Would you like to go first or second? Enter 1 for first, 0 for second:\n> ");
        String answ = sc.next();
        sc.nextLine();
        if (answ.equals("1"))
            return true;
        return false;
    }
}
