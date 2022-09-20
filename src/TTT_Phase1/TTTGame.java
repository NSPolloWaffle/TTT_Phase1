package TTT_Phase1;
import java.util.*;

public class TTTGame {
    Player[] players = new Player[2];
    private String[] marks = {"X", "O"};
    private int row = 3;
    private int col = 3;
    private String name = "Tic Tac Toe";
    Board board = new Board();

    public TTTGame() {
        setPlayer();
        setBoard();
        start();
    }
    public TTTGame(int row, int col){
        this.row = row;
        this.col = col;
        setPlayer();
        setBoard();
        start();
    }
    boolean gameOver(Player[] players){
        if(isWinner(players[0]) || isWinner(players[1]) || board.isFull()){
            return true;
        }
        return false;
    }
    boolean isWinner(Player p){
        if(checkRow(p) || checkCol(p) || checkDiagRL(p) || checkDiagLR(p)){
            return true;
        }
        return false;
    }
    boolean checkRow(Player p){
        boolean win = false;
        for(int i = 0; i < board.getRow(); i++) {
            for(int j = 0; j < board.getCol(); j++){
                if (board.getMark(board.getRow() * i + j) == p.getMark()) {
                    win = true;
                }
                else {
                    win = false;
                    break;
                }
            }
            if(win){
                return true;
            }
        }
        return false;
    }
    boolean checkCol(Player p){
        boolean win = false;
        for(int i = 0; i < board.getCol(); i++) {
            for(int j = 0; j < board.getRow(); j++){
                if (board.getMark(board.getRow() * j + i) == p.getMark()) {
                    win = true;
                }
                else {
                    win = false;
                    break;
                }
            }
            if(win){
                return true;
            }
        }
        return false;
    }
    boolean checkDiagRL(Player p){
        boolean win = false;
        int count = 0;
        for(int i = board.getRow() - 1; i >= 0; i--) {
            if (board.getMark(board.getRow() * i + count) == p.getMark()) {
                win = true;
            }
            else {
                win = false;
                break;
            }
            count++;
        }
        if(win){
            return true;
        }
        return false;
    }
    boolean checkDiagLR(Player p){
        boolean win = false;
        for(int i = 0; i < board.getRow(); i++) {
            if (board.getMark(board.getRow() * i + i) == p.getMark()) {
                win = true;
            }
            else {
                win = false;
                break;
            }
        }
        if(win){
            return true;
        }
        return false;
    }
    int validateRow(int r, Player p, Scanner s){
        while(r >= board.getRow() || r < 0){
            System.out.println("Invalid input, try again");
            System.out.print(p.getName() + ", please select a row number (0-" + (board.getRow() - 1) +"): ");
            r = s.nextInt();
        }
        return r;
    }
    int validateCol(int c, Player p, Scanner s){
        while(c >= board.getCol() || c < 0){
            System.out.println("Invalid input, try again");
            System.out.print(p.getName() + ", please select a row number (0-" + (board.getCol() - 1) +"): ");
            c = s.nextInt();
        }
        return c;
    }
    void turn(Player p){
        int in_row = 0;
        int in_col = 0;

        Scanner s = new Scanner(System.in);
        System.out.print(p.getName() + ", please select a row number (0-" + (board.getRow() - 1) +"): ");
        in_row = validateRow(s.nextInt(), p, s);

        System.out.print(p.getName() + ", please select a col number (0-" + (board.getCol() - 1) +"): ");
        in_col = validateCol(s.nextInt(), p, s);

        if(!board.makeMove(in_row, in_col, p.getMark())){
            System.out.println("Invalid input (row = " + in_row + ", column = " + in_col + ")");
            System.out.println("Please try again");
            turn(p);
        }
        else{
            board.print();
        }
    }
    void setPlayer(){
        for(int i = 0; i < players.length; i++){
            Player p = new Player("Player " + (i+1), marks[i]);
            players[i] = p;
        }
    }
    void switchPlayers(){
        Player temp = players[1] ;
        players[1] = players[0];
        players[0] = temp;
    }
    public Board getBoard() {
        return board;
    }

    public void setBoard() {
        this.board = new Board(row,col,name);
    }

    void start(){
        board.print();

        while(!gameOver(players)){
            for(int i = 0; i < players.length; i++){
                turn(players[i]);
                if(isWinner(players[i])){
                    System.out.println(players[i].getName() + " wins!");
                    break;
                }
                if(board.isFull()){
                    System.out.println(board.getName() + " board is now full, tied game, game over.");
                    break;
                }
            }
        }
    }
}


