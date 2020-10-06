public class heuristic{
    private int[][] board;

    public heuristic(int[][] board) {
        this.board = board;
    }
    public int cF3IC_R_D(int column){
        if(true){
            return column;
        }
        return 0;
    }
    public int cF2IC_R_D(){
        return 1;
    }
    public int gravity(int column){
        for (int i = board.length -1; i >= 0 ; i--) {
            if(board[i][column] == Board.NO_PLAYER){
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