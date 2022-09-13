package TTT_Phase1;

public class Board {
    private int row;
    private int col;
    private Box[] boxes;
    private String name;

    Board() {

    }

    private void setSize(int row, int col) {
        if(row < 3 || col < 3) {
            System.out.println("min board size is 3");
        }
        else {
            this.setCol(col);
            this.setRow(row);
            init();
        }
    }

    private void init(){
        boxes = new Box[row * col];
        for( int i = 0; i < boxes.length; i++){
            Box b = new Box(i / col, i % col);
            boxes[i] = b;
        }
    }

    private void print(){

    }

    public Board(int row, int col, String name) {
        this.row= row;
        this.col = col;
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
