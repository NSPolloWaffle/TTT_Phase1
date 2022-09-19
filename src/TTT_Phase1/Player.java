package TTT_Phase1;

import java.util.Scanner;

public class Player {
    private String name;
    private String mark;
    int validateRow(int r, Board b, Scanner s){
        while(r >= b.getRow()){
            System.out.println("Invalid input, try again");
            System.out.print(this.getName() + ", please select a row number (0-" + (b.getRow() - 1) +"): ");
            r = s.nextInt();
        }
        return r;
    }
    int validateCol(int c, Board b, Scanner s){
        while(c >= b.getCol()){
            System.out.println("Invalid input, try again");
            System.out.print(this.getName() + ", please select a row number (0-" + (b.getCol() - 1) +"): ");
            c = s.nextInt();
        }
        return c;
    }
    void turn(Board b){
        int row = 0;
        int col = 0;

        Scanner s = new Scanner(System.in);
        System.out.print(this.getName() + ", please select a row number (0-" + (b.getRow() - 1) +"): ");
        row = validateRow(s.nextInt(), b, s);

        System.out.print(this.getName() + ", please select a col number (0-" + (b.getCol() - 1) +"): ");
        col = validateCol(s.nextInt(), b, s);

        if(!b.move(row, col, this.getMark())){
            System.out.println("Invalid input (row = " + row + ", column = " + col + ")");
            System.out.println("Please try again");
            turn(b);
        }
        else{
            b.print();
        }
    }
    public Player(String name, String mark) {
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
}
