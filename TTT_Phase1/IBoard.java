package TTT_Phase1;

public interface IBoard {
    String getMark(int square);
    void setSize(int row, int col);
    void reset();
    boolean makeMove(int s, String mark);
    void print();
    boolean isFull();
    int getRow();
    int getCol();
    APlayer getWinner();
    void setWinner(APlayer p);
    boolean hasWinner();
    String getName();
}
