import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Board b = new Board();
        AI ai = new AI();
        AI ai2 = new AI();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gamemode: AI vs Human (1), AI vs AI (2): ");
        int gamemode = scanner.nextInt();
        if(gamemode == 1){
            b.displayBoard();
            while(!b.isGameOver()) {
                boolean moveOk = true;
                do {
                    if (!moveOk) {
                        System.out.println("Cell already filled !");
                    }
                    System.out.println("Your move: ");
                    Integer userMove = scanner.nextInt();
                    moveOk = b.placeMove(userMove, Board.PLAYER_R);
                } while (!moveOk);

                b.displayBoard();
                if (b.isGameOver()) {
                    break;
                }
                System.out.println(b.getAvailableCells());

                ai.minimax(0, Board.PLAYER_Y, b, "Y");
                b.placeMove(ai.getComputerMove() + 1, Board.PLAYER_Y);
                //System.out.println(ai.getComputerMove());
                //System.out.println(b.getAvailableCells());
                b.displayBoard();
            }
            if(b.checkWin(Board.PLAYER_Y)){
                System.out.println("You Lost !");
            }
            else if(b.checkWin(Board.PLAYER_R)){
                System.out.println("You win !");
            }
            else {
                System.out.println("Draw !");
            }
        }
        else if(gamemode == 2){
            while(!b.isGameOver()){
                ai.minimax(0, Board.PLAYER_Y, b, "Y");
                b.placeMove(ai.getComputerMove()+1, Board.PLAYER_Y);
                b.displayBoard();
                ai2.minimax(0, Board.PLAYER_R, b, "R");
                b.displayBoard();
                b.placeMove(ai2.getComputerMove()+1, Board.PLAYER_R);

            }
            if(b.checkWin(Board.PLAYER_Y)){
                System.out.println("AI Yellow Won !");
            }
            else if(b.checkWin(Board.PLAYER_R)){
                System.out.println("AI Red Won !");
            }
            else {
                System.out.println("Draw !");
            }
        }




    }
}
