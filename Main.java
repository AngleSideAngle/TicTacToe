import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // main game loop
        do {
            Game game = new Game();
            while (game.round());
        } while (playAgain());
    }

    public static boolean playAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Would you like to play again? Enter 1 for yes, 0 for no:\n> ");
        String answ = sc.nextLine();
        sc.close();
        if (answ.equals("1"))
            return true;
        return false;
    }
}
