public class Game {
    private Board board;
    private Human human;
    private Opponent opponent;

    public Game() {
        board = new Board(3, 3);
        human = new Human();
        opponent = new Opponent();
    }
}
