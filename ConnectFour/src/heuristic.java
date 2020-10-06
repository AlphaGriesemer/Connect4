public class heuristic{
    private Board board;

    public heuristic(Board board) {
        this.board = board;
    }
    public int cF3IC_R_D(int player){
        for(int i = 0; i < this.board.getBoard().length; i++){
            for(int n = 0; n < this.board.getBoard()[0].length; n++){
                if(board.getBoard()[i][n] == player) {
                    if(board.checkUp(3, i, n)){
                        return n;
                    }
                    if(board.checkDown(3, i, n)){
                        return n;
                    }
                    if(board.checkLeft(3, i, n)){
                        return n - 3;
                    }
                    if(board.checkRight(3, i, n)){
                        return n + 3;
                    }
                    if(board.checkDiagRight(3, i, n)){
                        return n + 3;
                    }
                    if(board.checkDiagLeft(3, i, n)){
                        return n - 3;
                    }
                }
            }
        }
    }
    public int cF2IC_R_D(){
        return 1;
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