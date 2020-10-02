public class heuristic {
    private int[][] board;
    public heuristic(int[][] b){
        board = b;
    }
    private boolean checkDown(int row, int col){
        int value = board[row][col];
        for(int i = 0; i < 3; i++){
            if(row + i >= board.length) {
                return false;
            }
            if(board[row + i][col] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkUp(int row, int col){
        int value = board[row][col];
        for(int i = 0; i < 3; i++){
            if(row - i < 0){
                return false;
            }
            if(board[row - i][col] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkLeft(int row, int col) {
        int value = board[row][col];
        for(int i = 0; i < 3; i++){
            if(col - i < 0){
                return false;
            }

            if(board[row][col - i] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkRight(int row, int col){
        int value = board[row][col];
        for(int i = 0; i < 3; i++){
            if (col + i >= board.length){
                return false;
            }

            if(board[row][col + i] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagLeft(int row, int col){
        int value = board[row][col];
        for(int i = 0; i < 3; i++){
            if(col - i < 0 || row + i >= board.length){
                return false;
            }

            if(board[row + i][col - i] != value){
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagRight(int row, int col){
        int value = board[row][col];
        for(int i = 0; i < 3; i++){
            if(col + i >= board[0].length || row + i >= board.length){
                return false;
            }

            if(board[row + i][col + i] != value){
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(int player){
        for(int i = 0; i < board.length; i++){
            for(int n = 0; n < board[0].length; n++){
                if(board[i][n] == player) {
                    if(this.checkUp(i, n)){
                        return true;
                    }
                    if(this.checkDown(i, n)){
                        return true;
                    }
                    if(this.checkLeft(i, n)){
                        return true;
                    }
                    if(this.checkRight(i, n)){
                        return true;
                    }
                    if(this.checkDiagRight(i, n)){
                        return true;
                    }
                    if(this.checkDiagLeft(i, n)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
