package TTT_Phase1;

public class OtherBoardWrapper implements IBoard{

    OtherBoard otherBoard = new OtherBoard();
    private APlayer winner;
    public String getMark(int square){
        return otherBoard.getMark(square / 3, square % 3);
    }
    public void setSize(int row, int col){
        otherBoard.setSize(row, col);
    }
    public void init(){

    }
    public void reset(){
        otherBoard.reset();
    }
    public boolean makeMove(int s, String mark){
        return otherBoard.setMark(s/3, s%3, mark);
    }

    public void print(){
        otherBoard.printMyBoard();
    }
    public boolean isFull(){
       return (otherBoard.emptyCells().length == 0);
    }

    public int getRow(){
        return otherBoard.getRowSize();
    }

    public int getCol(){
        return otherBoard.getColSize();
    }

    public String getName(){
        return otherBoard.getName();
    }
    public void setWinner(APlayer p){
        winner = p;
    }
    public APlayer getWinner(){
        return winner;
    }
    public boolean hasWinner(){
        return winner != null;
    }
}
