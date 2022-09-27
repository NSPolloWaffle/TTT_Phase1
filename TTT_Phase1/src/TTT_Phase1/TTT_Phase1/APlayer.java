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
    int randomNumber(int range){
        return (int)(Math.random() * range);
    }
    void turn(IBoard board){};
    int validateRow(int r, APlayer p, Scanner s, IBoard board){
        while(r >= board.getRow()){
            System.out.println("Invalid input, try again");
            System.out.print(p.getName() + ", please select a row number (0-" + (board.getRow() - 1) +"): ");
            r = s.nextInt();
        }
        return r;
    }
    int validateCol(int c, APlayer p, Scanner s, IBoard board){
        while(c >= board.getCol()){
            System.out.println("Invalid input, try again");
            System.out.print(p.getName() + ", please select a row number (0-" + (board.getCol() - 1) +"): ");
            c = s.nextInt();
        }
        return c;
    }
}
