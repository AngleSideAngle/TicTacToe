public class Opponent {
    private Player player;

    public Opponent() {
        player = new Player('O');
    }

    public void move(Board board) {
        while (true) {
            int[] coords = findRandomMove(board.getBoard());
            if (player.move(board, coords[0], coords[1]))
                break;
        }
    }


    /*
    public int[] findNextMove(char[][] board) {
        ArrayList<int[]> coords = new ArrayList<int[]>();
        for (int )
    }
    */

    public int[] findRandomMove(char[][] board) {
        int[] coords = new int[2];
        coords[0] = (int) (Math.random() * 4);
        coords[1] = (int) (Math.random() * 4);
        return coords;
    }
}