package TTT_Phase1;

import java.util.Scanner;

public class HumanPlayer extends APlayer{
    public HumanPlayer(){

    }

    public HumanPlayer(String name, String mark){
        super(name, mark);
    }

    void turn(IBoard board){
        int in_row = 0;
        int in_col = 0;

        Scanner s = new Scanner(System.in);
        System.out.print(this.getName() + ", please select a row number (0-" + (board.getRow() - 1) +"): ");
        in_row = validateRow(s.nextInt(), s, board);

        System.out.print(this.getName() + ", please select a col number (0-" + (board.getCol() - 1) +"): ");
        in_col = validateCol(s.nextInt(), s, board);

        if(!board.makeMove(in_row, in_col, this.getMark())){
            System.out.println("Invalid input (row = " + in_row + ", column = " + in_col + ")");
            System.out.println("Please try again");
            this.turn(board);
        }
        else{
            board.print();
        }
    }
}
