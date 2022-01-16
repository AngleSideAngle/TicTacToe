public class Human extends Player {

    public Human() {
        super('X');
    }

    public void move(Board board) {
        while (true) {
            int[] coords = prompt();
            if (move(board, coords[0], coords[1]))
                break;
            System.out.println("Enter a valid coordinate pair in the form X, Y");
        }
    }

    public int[] prompt() {
        int[] coords = new int[2];
        System.out.print("Enter X,Y coordinates for your move: ");
        String pair = Main.sc.nextLine();
        pair = pair.trim();   
        try {
            coords[0] = Integer.parseInt(pair.substring(0, 1)) - 1;
            coords[1] = Integer.parseInt(pair.substring(pair.length() - 1, pair.length())) - 1;
        } catch (Exception e) {
            coords[0] = 4;
            coords[1] = 4;
        }
        return coords;
    }
}
