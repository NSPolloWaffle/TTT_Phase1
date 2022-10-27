
package TTT_Phase1;
import java.util.*;

public class TTTGame {
    private APlayer[] players = new APlayer[2];
    private String[] marks = {"X", "O"};
    private int row = 3;
    private int col = 3;
    private String name = " Ultimate Tic Tac Toe";
    private int indexCurrPlayer = -1;
    private UltimateBoard board;
    private int scoreToWin = 3;

    public TTTGame() {
        setPlayers();
        setBoard();
    }
    public TTTGame(int row, int col){
        this.row = row;
        this.col = col;
        setPlayers();
        setBoard();
    }
    void setPlayers(){
        Scanner in = new Scanner(System.in);
        for(int i = 0; i < players.length; i++){
            System.out.println("Player " + (i + 1) + ", please enter if you want to be a human player (y/n): ");
            String playerType = in.nextLine();
            while(!playerType.equals("Y") && !playerType.equals("N") && !playerType.equals("y") && !playerType.equals("n")){
                System.out.println("Invalid input, " + playerType + " try again: ");
                playerType = in.nextLine();
            }
            if(playerType.equals("y") || playerType.equals("y")){
                HumanPlayer hp = new HumanPlayer("Player " + (i + 1), marks[i]);
                players[i] = hp;
            }
            else{
                ComputerPlayer cp = new ComputerPlayer("Player " + (i+1), marks[i]);
                players[i] = cp;
            }
        }
    }
    private void setBoard() {
        this.board = new UltimateBoard(row,col,name);
    }
    public void setBoard(IBoard board) {
        System.out.println("The Other board will be used.");
        this.board = new UltimateBoard(board.getRow(), board.getCol(), "Other Ultimate TTT");
    }

    boolean ultGameOver(APlayer[] players){
        if(board.ultIsFull() || isUltWinner(players[0]) || isUltWinner(players[1])){
            return true;
        }
        return false;
    }
    boolean isWinner(APlayer p, IBoard b){
        if(checkRow(p, b) || checkCol(p, b) || checkDiagRL(p, b) || checkDiagLR(p, b)){
            return true;
        }
        return false;
    }
    boolean isUltWinner(APlayer p){
        if(board.checkUltRow(p) || board.checkUltCol(p) || board.checkUltDiagLR(p) || board.checkUltDiagRL(p)){
            return true;
        }
        return false;
    }
    boolean checkRow(APlayer p, IBoard b){
        int score = 0;
        for(int i = 0; i < board.getRow(); i++) {
            for(int j = 0; j < board.getCol(); j++){
                if(!b.getMark(i * board.getRow() + j).equals(p.getMark())) {
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
    boolean checkCol(APlayer p, IBoard b){
        int score = 0;
        for(int i = 0; i < board.getRow(); i++) {
            for(int j = 0; j < board.getCol(); j++){
                if(!b.getMark(j * board.getCol() + i).equals(p.getMark())) {
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
    boolean checkDiagRL(APlayer p, IBoard b){
        int score = 0;
        for(int i = 0; i < board.getRow(); i++) {
            if(!b.getMark( (i + 1) * (board.getRow() - 1)).equals(p.getMark())){
                break;
            }
            score++;
        }
        if(score == scoreToWin){
            return true;
        }
        return false;
    }
    boolean checkDiagLR(APlayer p, IBoard b){
        int score = 0;
        for(int i = 0; i < board.getRow(); i++) {
            if(!b.getMark(i * board.getRow() + i).equals(p.getMark())){
                break;
            }
            score++;
        }
        if(score == scoreToWin){
            return true;
        }
        return false;
    }

    void switchPlayers(){
        if(indexCurrPlayer == -1 || indexCurrPlayer == 1){
            indexCurrPlayer = 0;
        }
        else{
            indexCurrPlayer = 1;
        }
    }


    /**
     * 1 - Print message to start the game
     * 2 - Select the player
     * 3 - Player needs to make move by selecting a row and col from the board
     * 4 - Board will check the availability of the box
     * 5 - If available, set the location for the mark
     * 6 - Otherwise, ask user to repeat step 3
     * 7 - Print the updated board
     * 8 - Check if there is a winner or the board is full (stopping point)
     * 9 - Repeat step 2 if there is no winner
     */
    void start(){
        int next_board = -1;
        int prev_board = 0;
        System.out.println("Game started...");
        do{
            switchPlayers();
            prev_board = next_board;
            next_board = players[indexCurrPlayer].turn(board, prev_board);
            board.print();
            if(prev_board >= 0 && !board.getBoard(prev_board).hasWinner() && isWinner(players[indexCurrPlayer], board.getBoard(prev_board))){
                board.getBoard(prev_board).setWinner(players[indexCurrPlayer]);
                System.out.println(players[indexCurrPlayer].getName() + " has won board " + prev_board);
            }
            System.out.println();
            for(int i = 0; i < board.getCol() * board.getRow(); i++){
                if(board.getBoard(i).hasWinner()) {
                    System.out.println(board.getBoard(i).getWinner().getName() + " won board " + i);
                }
            }
        }
        while(!ultGameOver(players));
        if(isUltWinner(players[indexCurrPlayer])){
            System.out.println(players[indexCurrPlayer].getName() + " wins!");
        }
        else{
            System.out.println(board.getName() + " board is now full, game over.");
        }
    }
}
