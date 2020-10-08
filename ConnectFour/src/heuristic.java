import java.util.ArrayList;
import java.util.List;

public class heuristic{
    private Board board;

    public heuristic(Board board) {
        this.board = board;
    }
    //hi alex! (-:
    //hi channing (-:
    public int checkForPossWin(int player, int length){
        int value = -1;
        for(int i = 0; i < this.board.getBoard().length; i++){
            for(int n = 0; n < this.board.getBoard()[0].length; n++){
                if(board.getBoard()[i][n] == player) {
                    if(board.checkUp(length, i, n)){
                        value = n;
                    }
                    if(board.checkDown(length, i, n)){
                        value = n;
                    }
                    if(board.checkLeft(length, i, n)){

                       value = n - 3;
                    }
                    if(board.checkRight(length, i, n)){
                        value = n + 3;
                    }
                    if(board.checkDiagRight(length, i, n)){
                        value = n + 3;
                    }
                    if(board.checkDiagLeft(length, i, n)){
                        value = n - 3;
                    }
                }
            }
        }
        System.out.println(board.getAvailableCells().get(0));
        if(value != -1){
            int row = gravity(value);
            List<Integer> row_column = new ArrayList<>();
            row_column.add(row);
            row_column.add(value);
            for (int i = 0; i < board.getAvailableCells().size(); i++) {
                if(board.getAvailableCells().get(i) == row_column){
                    return value;
                }
            }
        }
        return -1;
    }

    public int gravity(int column){
        for (int i = board.getBoardLength() -1; i >= 0 ; i--) {
            if(board.getBoard()[i][column] == Board.NO_PLAYER){
                return i;
            }
        }
        return 0;
    }
}

/*
private Board board(){

checkFor3InAColumn

gravity(int column){
getLowestAvailableCell
return GLAC
}

 */