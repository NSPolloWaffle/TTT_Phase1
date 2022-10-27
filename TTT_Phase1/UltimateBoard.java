package TTT_Phase1;

public class UltimateBoard {
    private IBoard[] board;
    private int row;
    private int col;
    private int scoreToWin = 3;
    private String name;

    public UltimateBoard(){
        setSize(3,3);
        this.setName("Ultimate TTT");
    }
    public UltimateBoard(int row, int col, String name){
        setSize(row, col);
        this.setName(name);
    }
    public UltimateBoard(IBoard b){
        this.setCol(col);
        this.setRow(row);
        this.board = new IBoard[this.row * this.col];
        for(int i = 0; i < board.length; i++){
            this.board[i] = b;
        }
        this.setName("Other Ultimate TTT");
    }
    public void setSize(int row, int col) {
        if(row < 3 || col < 3) {
            System.out.println("Min board size is 3");
        }
        else {
            this.setCol(col);
            this.setRow(row);
            init();
        }
    }

    public void init(){
        board = new IBoard[row * col];
        for(int i = 0; i < board.length; i++){
            Board b = new Board(row, col,  "TTT");
            board[i] = b;
        }
    }
    boolean checkUltRow(APlayer p){
        int score = 0;
        for(int i = 0; i < this.getRow(); i++) {
            for(int j = 0; j < this.getCol(); j++){
                if(board[i * this.getRow() + j].getWinner() != p) {
                    break;
                }
                score++;
            }
            if(score == scoreToWin){
                return true;
            }
            score = 0;
        }
        return false;
    }
    boolean checkUltCol(APlayer p){
        int score = 0;
        for(int i = 0; i < this.getRow(); i++) {
            for(int j = 0; j < this.getCol(); j++){
                if(board[j * this.getCol() + i].getWinner() != p) {
                    break;
                }
                score++;
            }
            if(score == scoreToWin){
                return true;
            }
            score = 0;
        }
        return false;
    }
    boolean checkUltDiagRL(APlayer p){
        int score = 0;
        for(int i = 0; i < this.getRow(); i++) {
            if(board[(i + 1) * (this.getRow() - 1)].getWinner() != p){
                break;
            }
            score++;
        }
        if(score == scoreToWin){
            return true;
        }
        return false;
    }
    boolean checkUltDiagLR(APlayer p){
        int score = 0;
        for(int i = 0; i < this.getRow(); i++) {
            if(board[i * this.getRow() + i].getWinner() != p){
                break;
            }
            score++;
        }
        if(score == scoreToWin){
            return true;
        }
        return false;
    }
    public void print(){
        System.out.println("Printing the " + this.name + " Board");
        int line = 0;
        int board_num = 0;
        int index = 0;
        int rows = 0;
        while(rows < this.row){
            for(int n = 0; n < this.row; n++){
                System.out.print("Board " + board_num + " | ");
                for(int j = index * this.row; j < (index * this.row) + this.row; j++){
                    System.out.print(board[board_num].getMark(j) + " | ");
                }
                board_num++;
                if(board_num % this.row == 0){
                    index++;
                    System.out.println();
                }
            }
            line++;
            if(line % this.row == 0){
                index = 0;
                rows++;
                if(rows < this.row) {
                    System.out.println("-----------------------------------------------------------------");
                }
            }
            board_num = rows * this.row;
        }
    }
    boolean ultIsFull(){
        for(int i = 0; i < board.length; i++){
            if(!board[i].isFull()){
                return false;
            }
        }
        return true;
    }
    public int getCol(){
        return col;
    }
    public void setCol(int col){
        this.col = col;
    }
    public int getRow(){
        return row;
    }
    public void setRow(int row){
        this.row = row;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    IBoard getBoard(int index){
        return board[index];
    }
}
