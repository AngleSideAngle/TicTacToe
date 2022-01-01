import java.util.Scanner;

class Main {
    public static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        // main game loop
        do {
            Game game = new Game();
            while (game.round());
        } while (playAgain());
        sc.close();
    }
    // more code

    public static boolean playAgain() {
        System.out.print("Would you like to play again? Enter 1 for yes, 0 for no:\n> ");
        String answ = sc.nextLine();
        if (answ.equals("1"))
            return true;
        return false;
    }
}
