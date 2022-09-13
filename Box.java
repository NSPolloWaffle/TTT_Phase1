package TTT_Phase1;

public class Box {
    private int row;
    private int col;
    private String placeHolder = "-";

    public Box(int row, int col) {
        this.row = row;
        this.col = col;
    }
    void print(){
        System.out.print(placeHolder + " ");
    }
}
