package TTT_Phase1;

public class ComputerPlayer extends APlayer{

    public ComputerPlayer() {}
    public ComputerPlayer(String name, String mark) {
        super(name, mark);
    }

    void turn(IBoard board){
        int row = randomNumber(board.getRow());
        int col = randomNumber(board.getCol());
        if(!board.makeMove(row, col, this.getMark())){
            this.turn(board);
        }
        else{
            board.print();
        }
    }
}
