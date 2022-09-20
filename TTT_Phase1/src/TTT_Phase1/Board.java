package TTT_Phase1;

public class Board {
    private int row;
    private int col;
    private Box[] boxes;
    private String name;

    Board() {
        this.setName("Tic Tac Toe");
        this.setSize(3,3);
    }
    Board(int row, int col, String name) {
        this.setName(name);
        this.setSize(row,col);
    }
    String getMark(int index){
        return boxes[index].getPlaceHolder();
    }
    private void setSize(int row, int col) {
        if(row < 3 || col < 3) {
            System.out.println("Min board size is 3");
        }
        else {
            this.setCol(col);
            this.setRow(row);
            init();
        }
    }

    private void init(){
        boxes = new Box[row * col];
        for(int i = 0; i < boxes.length; i++){
            Box b = new Box(i / col, i % col);
            boxes[i] = b;
        }
    }

    boolean makeMove(int r, int c, String mark){
        if(boxes[(r * 3) + c].setPlaceHolder(mark)){
            return true;
        }
        return false;
    }

    void print(){
        System.out.println("Printing the " + name + " board...");
        for(int i = 0; i < boxes.length; i++){
            if(i % col == 0 && i/col != 0) {
                System.out.println();
            }
            boxes[i].print();
        }
        System.out.println();
    }
    boolean isFull(){
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i].isAvailable()){
                return false;
            }
        }
        return true;
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
    public int getBoxesLength(){
        return this.boxes.length;
    }
}
