public class Graphic {

    public static void printBoard(int[][] board, int currentPlayer){
        System.out.println("                                               __ __ __ __ __ __ __ __ __ __ __");

        //Iterate trough each line of the board

        for(int i = 0; i < 17; i++){
            System.out.print("                                             |");

            //middle line case
            if(i == 5 || i == 11 ){
                System.out.print("__ __ __ __ __ __ __ __ __ __ __");
            }


            //regular line case: for each square in the line (3 per line)
            else {
                int row = -1;
                int col;

                if(i <= 4) row = 0;
                else if (i <= 11) row = 1;
                else row = 2;

                for(int j = 0; j < 3; j++){
                    col = j;

                    int scenario = board[row][col];

                    switch (scenario){
                        case 0-> System.out.print("          ");
                        case 1-> printLineX(i);
                        case 2-> printLineO(i);
                    }
                    System.out.print("|");
                }


            }

            System.out.println();
        }

        System.out.print("                                               __ __ __ __ __ __ __ __ __ __ __");

    }

    public static void printLineX(int line){
             if(line == 0 || line == 6 || line == 12)System.out.print("   \\   /  ");
        else if(line == 1 || line == 7 || line == 13)System.out.print("    \\ /   ");
        else if(line == 2 || line == 8 || line == 14)System.out.print("     \\    ");
        else if(line == 3 || line == 9 ||line == 15) System.out.print("    / \\   ");
        else if(line == 4 || line == 10 ||line == 16)System.out.print("   /   \\  ");
        else System.out.println("Error: line = " + line);
    }
    public static void printLineO(int line){
             if(line == 0 || line == 6 || line == 12)System.out.print("    ___   ");
        else if(line == 1 || line == 7 || line == 13)System.out.print("   /   \\  ");
        else if(line == 2 || line == 8 || line == 14)System.out.print("  |     | ");
        else if(line == 3 || line == 9 ||line == 15) System.out.print("   \\   /  ");
        else if(line == 4 || line == 10 ||line == 16)System.out.print("    ---   ");
        else System.out.println("Error: line = " + line);
    }


}
