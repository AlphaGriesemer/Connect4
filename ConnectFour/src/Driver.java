import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Board b = new Board();
        AI ai = new AI();
        Scanner scanner = new Scanner(System.in);
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

            ai.minimax(0, Board.PLAYER_Y, b);
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
}
