public class Human {
    private Player player;

    public Human() {
        player = new Player('X');
    }

    public void move(Board board) {
        while (true) {
            int[] coords = prompt();
            if (player.move(board, coords[0], coords[1]))
                break;
            System.out.println("Enter a valid coordinate pair in the form X, Y");
        }
    }

    public int[] prompt() {
        int[] coords = new int[2];
        System.out.print("Enter X,Y coordinates for your move: ");
        String pair = Main.sc.nextLine();
        coords[0] = Integer.parseInt(pair.substring(0, 1)) - 1;
        coords[1] = Integer.parseInt(pair.substring(2)) - 1;
        return coords;
    }
}
