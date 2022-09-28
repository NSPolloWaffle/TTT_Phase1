package TTT_Phase1;

import java.util.Scanner;

abstract class APlayer {
    private String name;
    private String mark;

    public APlayer(){};
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

    void turn(IBoard board){};
    int validateRow(int r, Scanner s, IBoard board){
        while(r >= board.getRow() || r < 0){
            System.out.println("Invalid input, try again");
            System.out.print(this.getName() + ", please select a row number (0-" + (board.getRow() - 1) +"): ");
            r = s.nextInt();
        }
        return r;
    }
    int validateCol(int c, Scanner s, IBoard board){
        while(c >= board.getCol()){
            System.out.println("Invalid input, try again");
            System.out.print(this.getName() + ", please select a row number (0-" + (board.getCol() - 1) +"): ");
            c = s.nextInt();
        }
        return c;
    }
}
