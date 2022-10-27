package TTT_Phase1;

public class ComputerPlayer extends APlayer{

    public ComputerPlayer() {}
    public ComputerPlayer(String name, String mark) {
        super(name, mark);
    }
    private int randomNumber(int range){
        return (int)(Math.random() * range);
    }
    int turn(UltimateBoard board, int board_index){
        if(board_index == -1 || board.getBoard(board_index).isFull()){
            do {
                board_index = randomNumber(board.getRow() * board.getCol());
            }
            while(board.getBoard(board_index).isFull());
        }
        int square = randomNumber(board.getRow() * board.getCol());

        while(!board.getBoard(board_index).makeMove(square, this.getMark())){
            square = randomNumber(board.getRow() * board.getCol());
        }
        return square;
    }
}
