class Main {
    public static void main(String[] args) {
        while (true) {
            Game game = new Game();
            while (game.round());
            break;
        }
    }

}
