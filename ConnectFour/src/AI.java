import java.util.List;
import java.util.Random;

public class AI extends Board {
    private int depth;
    //private Board board;
    private Integer computerMove;

    AI(){
        System.out.println(computerMove);
    }

    public int getComputerMove(){
        return computerMove;
    }

    public int minimax(int depth, int turn, Board board, String aiPlayer) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Random random = new Random();
        if(aiPlayer.equals("Y")){
            if(depth == 6){
                heuristic h = new heuristic(board);
                if(h.checkForPossWin(PLAYER_Y, 3) == -1){
                    if(h.checkForPossWin(PLAYER_Y, 2) == -1){
                        return random.nextInt(10);
                    } else {
                        return h.checkForPossWin(PLAYER_Y, 2);
                    }
                } else {
                    return h.checkForPossWin(PLAYER_Y, 3);
                }
            }
            int bestMoveSoFar = -1;
            List<List<Integer>> availableCells = board.getAvailableCells();

            if (board.checkWin(PLAYER_Y, 4)) {
                return 10;

            }
            else if (board.checkWin(PLAYER_R, 4)) {
                return -10;
            }

            if (availableCells.isEmpty()) {
                return 0;
            }

            for (int i = 0; i < availableCells.size(); i++) {
                List<Integer> point = availableCells.get(i);
                board.setPlayer(point.get(0), point.get(1), turn);
                if (turn == PLAYER_Y) {
                    int currentScore = minimax(depth + 1, PLAYER_R, board, "Y");
                    if(currentScore > max){
                        max = currentScore;
                        bestMoveSoFar = point.get(1);
                    }
                }
                else if (turn == PLAYER_R) {
                    int currentScore = minimax(depth + 1, PLAYER_Y, board, "Y");
                    min = Math.min(currentScore, min);
                }
                board.setNoPlayer(point.get(0), point.get(1));
            }
            computerMove = bestMoveSoFar;
            if(turn == PLAYER_Y){
                return max;
            }
            else{
                return min;
            }
        }
        else{
            if(depth == 6){
                heuristic h = new heuristic(board);
                if(h.checkForPossWin(PLAYER_Y, 3) == -1){
                    if(h.checkForPossWin(PLAYER_Y, 2) == -1){
                        return random.nextInt(10);
                    } else {
                        return h.checkForPossWin(PLAYER_Y, 2);
                    }
                } else {
                    return h.checkForPossWin(PLAYER_Y, 3);
                }
            }
            int bestMoveSoFar = -1;
            List<List<Integer>> availableCells = board.getAvailableCells();

            if (board.checkWin(PLAYER_Y, 4)) {
                return 10;

            }
            else if (board.checkWin(PLAYER_R, 4)) {
                return -10;
            }

            if (availableCells.isEmpty()) {
                return 0;
            }

            for (int i = 0; i < availableCells.size(); i++) {
                List<Integer> point = availableCells.get(i);
                board.setPlayer(point.get(0), point.get(1), turn);
                if (turn == PLAYER_R) {
                    int currentScore = minimax(depth + 1, PLAYER_Y, board, "R");
                    if(currentScore > max){
                        max = currentScore;
                        bestMoveSoFar = point.get(1);
                    }
                }
                else if (turn == PLAYER_Y) {
                    int currentScore = minimax(depth + 1, PLAYER_R, board, "R");
                    min = Math.min(currentScore, min);
                }
                board.setNoPlayer(point.get(0), point.get(1));
            }
            computerMove = bestMoveSoFar;
            if(turn == PLAYER_R){
                return max;
            }
            else{
                return min;
            }
        }
    }
}
//    if Red wins
//        return score 10;
//    else if Yellow (opponent) wins
//        return score -10;
//    else if no empty locations (cats game)
//        return score 0;
//    else if depth level is 6;
//    if red "one-away from winning" count > yellow "one-away from winning" count
//        return red count of one-away winning
//    else if yellow "one-away from winning count" > yellow "one-away from winning";
//        return (yellow count of one-away winning) * -1;
//        else
//            return a random value


//if(


//    public int minimax(int depth, int turn){
//        if(hasPlayerWon(PLAYER_X)){
//            return 1;
//        }
//        else if(hasPlayerWon(PLAYER_O)){
//            return -1;
//        }
//
//        List<Point> availableCells = getAvailableCells();
//
//        if(availableCells.isEmpty()){
//            return 0;
//        }
//
//        int min = Integer.MAX_VALUE;
//        int max = Integer.MIN_VALUE;
//
//        for (int i = 0; i < availableCells.size(); i++) {
//            Point point = availableCells.get(i);
//
//            if(turn == PLAYER_X){
//                placeMove(point, PLAYER_X);
//                int currentScore = minimax(depth + 1, PLAYER_O);
//                max = Math.max(currentScore, max);
//                if(depth == 0){
//                    //System.out.println("Computer score for position " + point + "=" + currentScore);
//                }
//                if(currentScore >= 0){
//                    if(depth == 0){
//                        computerMove = point;
//                    }
//                }
//                if(currentScore == 1){
//                    board[point.x][point.y] = NO_PLAYER;
//                    break;
//                }
//                if(i == availableCells.size() - 1 && max < 0){
//                    if(depth == 0){
//                        computerMove = point;
//                    }
//                }
//            }
//
//            else if(turn == PLAYER_O){
//                placeMove(point, PLAYER_O);
//                int currentScore = minimax(depth + 1, PLAYER_X);
//                min = Math.min(currentScore, min);
//                if(min == -1){
//                    board[point.x][point.y] = NO_PLAYER;
//                    break;
//                }
//            }
//            board[point.x][point.y] = NO_PLAYER;
//        }
//        return turn == PLAYER_X ? max : min;
//    }

