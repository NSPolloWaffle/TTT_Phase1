package TTT_Phase1;

public class OtherBoardWrapper implements IBoard{

    OtherBoard otherBoard = new OtherBoard();
    public String getMark(int row, int col){
        return otherBoard.getMark(row, col);
    }
    public void setSize(int row, int col){
        otherBoard.setSize(row, col);
    }
    public void init(){

    }
    public void reset(){
        otherBoard.reset();
    }
    public boolean makeMove(int r, int c, String mark){
        return otherBoard.setMark(r, c, mark);
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
}
