public class Player {
    protected char sign;

    public Player(char s) {
        sign = s;
    }

    // sets the point to player's sign, same return conditions as Board.setPoint()
    public boolean move(Board board, int x, int y) {
        return board.setPoint(sign, x, y);
    }

    public char getSign() {
        return sign;
    }
}
