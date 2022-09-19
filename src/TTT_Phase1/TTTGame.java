package TTT_Phase1;
import java.util.*;

public class TTTGame {
    private Player p1 = new Player("Player X", "X");
    private Player p2 = new Player("Player O", "O");

    Board board = new Board();
    void setPlayer(String name, String mark){
        if(p1 == null){
            p1.setName(name);
            p1.setMark(mark);
        }
        else{
            p2.setName(name);
            p2.setMark(mark);
        }
    }
    void switchPlayers(){
        Player temp = p1;
        p1 = p2;
        p2 = temp;
    }
    boolean gameOver(Board b, Player p1, Player p2){
        if(isWinner(b,p1) || isWinner(b,p2) || b.isFull()){
            System.out.println(b.isFull());
            return true;
        }
        return false;
    }
    boolean isWinner(Board b, Player p){
        if(checkRow(b,p) || checkCol(b,p) || checkDiagRL(b,p) || checkDiagLR(b,p)){
            return true;
        }
        return false;
    }
    boolean checkRow(Board b, Player p){
        boolean win = false;
        for(int i = 0; i < b.getRow(); i++) {
            for(int j = 0; j < b.getCol(); j++){
                if (b.getMark(b.getRow() * i + j) == p.getMark()) {
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
    boolean checkCol(Board b, Player p){
        boolean win = false;
        for(int i = 0; i < b.getCol(); i++) {
            for(int j = 0; j < b.getRow(); j++){
                if (b.getMark(b.getRow() * j + i) == p.getMark()) {
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
    boolean checkDiagRL(Board b, Player p){
        boolean win = false;
        int count = 0;
        for(int i = b.getRow() - 1; i >= 0; i--) {
            if (b.getMark(b.getRow() * i + count) == p.getMark()) {
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
    boolean checkDiagLR(Board b, Player p){
        boolean win = false;
        for(int i = 0; i < b.getRow(); i++) {
            if (b.getMark(b.getRow() * i + i) == p.getMark()) {
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


    public Board getBoard() {
        return board;
    }

    public void setBoard(int r, int c, String name) {
        board = new Board(r,c,name);
    }
    public TTTGame() {

    }

    void start(Board b){
        setPlayer("Player X", "X");
        setPlayer("Player O", "O");
        b.print();

        while(!gameOver(b,p1,p2)){
            p1.turn(b);
            if(isWinner(b,p1)){
                System.out.println(p1.getName() + " wins!");
                break;
            }
            p2.turn(b);
            if(isWinner(b,p2)){
                System.out.println(p1.getName() + " wins!");
                break;
            }
        }
    }
}


