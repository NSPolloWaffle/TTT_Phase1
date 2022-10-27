package TTT_Phase1;

import java.util.Scanner;

public class HumanPlayer extends APlayer{
    public HumanPlayer(){

    }

    public HumanPlayer(String name, String mark){
        super(name, mark);
    }

    int turn(UltimateBoard board, int board_index){
        int in;
        Scanner s = new Scanner(System.in);
        if(board_index == -1 || board.getBoard(board_index).isFull()) {
            do {
                System.out.print(this.getName() + ", please select a board between (0 and " + (board.getRow() * board.getCol() - 1) + "): ");
                board_index = (s.nextInt());
            }
            while (board.getBoard(board_index).isFull());
        }

        System.out.print(this.getName() + ", please select a square between (0 and " + (board.getRow() * board.getCol() - 1) +" on board " + board_index +"): ");
        in = validateSquare(s.nextInt(), this, s, board.getBoard(board_index));

        if(!board.getBoard(board_index).makeMove(in, this.getMark())){
            System.out.println("Invalid input " + in + ")");
            System.out.println("Please try again");
            this.turn(board, board_index);
        }
        return in;
    }
}
