package TTT_Phase1;

import java.util.Scanner;

abstract class APlayer {
    private String name;
    private String mark;

    public APlayer() {
    }

    ;

    public APlayer(String name, String mark) {
        setName(name);
        setMark(mark);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    abstract int turn(UltimateBoard board, int board_index);

    int validateSquare(int in, APlayer p, Scanner s, IBoard board) {
        while (in >= board.getCol() * board.getRow()) {
            System.out.println("Invalid input, try again");
            System.out.print(p.getName() + ", please select a row square between (0 and " + (board.getCol() * board.getRow() - 1) + "): ");
            in = s.nextInt();
        }
        return in;
    }
}
