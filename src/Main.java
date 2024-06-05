
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    private static boolean gameOver = false;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Board board = new Board();

        //X always goes first
        int currentPlayer = 1;

        int outcome = 0;

        while (!gameOver) {
            System.out.println("Starting Player is X");
            Graphic.printBoard(board.board, currentPlayer);
            System.out.println();
            System.out.print("Enter the Row of your next move:");
            int row = scan.nextInt();
            System.out.println();
            System.out.print("Enter the column of your next move:");
            int col = scan.nextInt();
            board.updateBoard(row,col,currentPlayer);

            //since this player's turn is over, switch turn to the other player
            if(currentPlayer == 1) currentPlayer = 2;
            else  currentPlayer = 1;

            outcome = checkGameStatus(board.board);
            switch (outcome){
                case 0 -> {
                }
                case 1, 2, 3->{ gameOver = true;
                    board.resetBoard();
                }

            }

        }

        Graphic.printBoard(board.board, currentPlayer);
        System.out.println();
        if (outcome == 0) System.out.println("GAME IS A DRAW");
        else System.out.println("CONGRATULATIONS PlAYER " + outcome + " FOR WINNING");


    }

    //returns 3 if game is a draw, otherwise returns the number of the winning player (X = 1, O = 2), returns 0 if game is ongoing
    static int checkGameStatus(int[][] board) {

        //checking for horizontal win for X
        if ((board[0][0] == 1 && board[0][1] == 1 && board[0][2] == 1) ||
                (board[1][0] == 1 && board[1][1] == 1 && board[1][2] == 1 ||
                        (board[2][0] == 1 && board[2][1] == 1 && board[2][2] == 1))) return 1;

        ////checking for horizontal win for O
        else if((board[0][0] == 2 && board[0][1] == 2 && board[0][2] == 2) ||
                (board[1][0] == 2 && board[1][1] == 2 && board[1][2] == 2 ||
                        (board[2][0] == 2 && board[2][1] == 2 && board[2][2] == 2))) return 2;


        //checking for vertical win for X
        else if ((board[0][0] == 1 && board[1][0] == 1 && board[2][0] == 1) ||
                (board[0][1] == 1 && board[1][1] == 1 && board[2][1] == 1 ||
                        (board[0][2] == 1 && board[1][2] == 1 && board[2][2] == 1))) return 1;

        //checking for vertical win for y
        else if ((board[0][0] == 2 && board[1][0] == 2 && board[2][0] == 2) ||
                (board[0][1] == 2 && board[1][1] == 2 && board[2][1] == 2 ||
                        (board[0][2] == 2 && board[1][2] == 2 && board[2][2] == 2))) return 2;


        //checking for diagonal win for x

        else if ((board[0][0] == 1 && board[1][1] == 1 && board[2][2] == 1) || ((board[2][0] == 1 && board[1][1] == 1 && board[0][2] == 1))) return 1;
        else if ((board[0][0] == 2 && board[1][1] == 2 && board[2][2] == 2) || ((board[2][0] == 2 && board[1][1] == 2 && board[0][2] == 2))) return 2;

        else if (Arrays.stream(board).flatMapToInt(Arrays::stream).allMatch(x -> x != 0)) {
            return 3;
        }
        else return 0;

    }




}