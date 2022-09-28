
package TTT_Phase1;

public interface IBoard {
    String getMark(int row, int col);
    void setSize(int row, int col);
    void reset();
    boolean makeMove(int r, int c, String mark);
    void print();
    boolean isFull();
    int getRow();
    int getCol();
    String getName();
}
