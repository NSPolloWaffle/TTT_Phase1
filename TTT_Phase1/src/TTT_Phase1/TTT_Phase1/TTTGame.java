package TTT_Phase1;

import java.util.Scanner;

public class TTTGame {
    private APlayer[] players = new APlayer[2];
    private String[] marks = {"X", "O"};
    private int row = 3;
    private int col = 3;
    private String name = "Tic Tac Toe";
    private int indexCurrPlayer = -1;
    private IBoard board;
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
    private void setBoard() {
        this.board = new Board(row,col,name);
    }
    public void setBoard(IBoard board) {
        System.out.println("The Other board will be used.");
        this.board = board;
    }
    boolean gameOver(APlayer[] players){
        if(isWinner(players[0]) || isWinner(players[1]) || board.isFull()){
            return true;
        }
        return false;
    }
    boolean isWinner(APlayer p){
        if(checkRow(p) || checkCol(p) || checkDiagRL(p) || checkDiagLR(p)){
            return true;
        }
        return false;
    }
    boolean checkRow(APlayer p){
        System.out.println("row");
        int score = 0;
        for(int i = 0; i < board.getRow(); i++) {
            for(int j = 0; j < board.getCol(); j++){
                System.out.println(board.getMark(i,j));
                if(!board.getMark(i,j).equals(p.getMark())) {
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
    boolean checkCol(APlayer p){
        int score = 0;
        for(int i = 0; i < board.getCol(); i++) {
            for(int j = 0; j < board.getRow(); j++){
                if(!board.getMark(j, i).equals(p.getMark())) {
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
    boolean checkDiagRL(APlayer p){
        boolean win = false;
        for(int i = board.getRow() - 1; i >= 0; i--) {
            if(board.getMark(i, board.getCol() - 1 - i).equals(p.getMark())){
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
    boolean checkDiagLR(APlayer p){
        boolean win = false;
        for(int i = 0; i < board.getRow(); i++) {
            if(board.getMark(i, i).equals(p.getMark())){
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
        System.out.println("Game started...");
        board.print();

        do{
            switchPlayers();
            players[indexCurrPlayer].turn(board);
        }
        while(!gameOver(players));

        if(isWinner(players[indexCurrPlayer])){
            System.out.println(players[indexCurrPlayer].getName() + " wins!");
        }
        else{
            System.out.println(board.getName() + " board is now full, game over.");
        }
    }
}
