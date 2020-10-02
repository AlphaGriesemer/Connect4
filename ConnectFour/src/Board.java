import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final int NO_PLAYER = 0;
    public static final int PLAYER_R = 1;
    public static final int PLAYER_Y = 2;
    private int[][] board = new int[6][7];
    public boolean isGameOver(){
        return checkWin(4, PLAYER_R) || checkWin(4, PLAYER_Y) || getAvailableCells().isEmpty();
    }
    public List<List<Integer>> getAvailableCells(){
        List<List<Integer>> availableCells = new ArrayList<>();
        for (int column = 0; column < board[0].length; column++) {
            int row = getCellBasedOnMove(column);
            if(row != 10){
                List<Integer> pair = new ArrayList<>();
                pair.add(row);
                pair.add(column);
                availableCells.add(pair);
            }
        }
        return availableCells;
    }
    public boolean checkWin2(int player){
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == board[3][3] && board[0][0] == player){
            return true;
        }
        else if (board[0][3] == board[1][2] && board[0][3] == board[2][1] && board[0][3] == board[3][0] && board[0][3] == player){
            return true;
        }

        for (int i = 0; i < 4 ; i++) {
            if((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == board[i][3] && board[i][0] == player)
                    ||
                    (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == board[3][i] && board[0][i] == player))
            {
                return true;
            }
        }
        return false;
    }

    private boolean checkDown(int length, int row, int col){
        int value = board[row][col];
        for(int i = 0; i < length; i++){
            if(row + i >= board.length) {
                return false;
            }
            if(board[row + i][col] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkUp(int length, int row, int col){
        int value = board[row][col];
        for(int i = 0; i < length; i++){
            if(row - i < 0){
                return false;
            }
            if(board[row - i][col] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkLeft(int length, int row, int col) {
        int value = board[row][col];
        for(int i = 0; i < length; i++){
            if(col - i < 0){
                return false;
            }

            if(board[row][col - i] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkRight(int length, int row, int col){
        int value = board[row][col];
        for(int i = 0; i < length; i++){
            if (col + i >= board.length){
                return false;
            }

            if(board[row][col + i] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagLeft(int length, int row, int col){
        int value = board[row][col];
        for(int i = 0; i < length; i++){
            if(col - i < 0 || row + i >= board.length){
                return false;
            }

            if(board[row + i][col - i] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagRight(int length, int row, int col){
        int value = board[row][col];
        for(int i = 0; i < length; i++){
            if(col + i >= board[0].length || row + i >= board.length){
                return false;
            }

            if(board[row + i][col + i] != value){
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(int player, int length){
        for(int i = 0; i < board.length; i++){
            for(int n = 0; n < board[0].length; n++){
                if(board[i][n] == player) {
                    if(this.checkUp(length, i, n)){
                        return true;
                    }
                    if(this.checkDown(length, i, n)){
                        return true;
                    }
                    if(this.checkLeft(length, i, n)){
                        return true;
                    }
                    if(this.checkRight(length, i, n)){
                        return true;
                    }
                    if(this.checkDiagRight(length, i, n)){
                        return true;
                    }
                    if(this.checkDiagLeft(length, i, n)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getBoardLength(){
        return board.length;
    }

    public int[][] getBoard(){
        return board;
    }
    public void displayBoard(){
        for(int i = 0; i < board[0].length; i++){
            System.out.print(i + 1);
        }
        System.out.println();
        int count = 1;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                String value = String.valueOf(count);
                if(board[i][j] == PLAYER_R){
                    value = "R";
                }
                else if(board[i][j] == PLAYER_Y){
                    value = "Y";
                }
                else{
                    value = "_";
                }
                System.out.print(value);
                count++;

            }
            System.out.println();
        }
        System.out.println();
    }
    public void setNoPlayer(int row, int column){
        board[row][column] = NO_PLAYER;
    }
    public void setPlayer(int row, int column, int player){
        board[row][column] = player;
    }
    public boolean placeMove(int move, int player){
        int secondNum = getCellBasedOnMove(move-1);
        if(secondNum == 10){
            return false;
        }
        board[secondNum][move-1] = player;
        return true;
    }
    private int getCellBasedOnMove(int column){

        for (int row = board.length-1; row >= 0; row--) {
            if(board[row][column] == NO_PLAYER){
                return row;
            }
        }
        return 10;
    }

}