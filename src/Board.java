import java.util.Arrays;

public class Board {

    private final int EMPTY = 0;
    private final int X = 1;
    private final int Y = 2;

    public int[][] board = new int[3][3];

    public Board(){

    }

    public void updateBoard(int x, int y,int symbol){
        board[x][y] = symbol;
    }

    public void resetBoard(){
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = EMPTY;
    }




}
