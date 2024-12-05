import java.util.Scanner;
 class TicTacToe {
    private static String [][] gameBoard = new String[3][3];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String player;
        String playerOne = " X ";
        String playerTwo = "O";
        int playerTurn = 0;

        boolean repeat = false;

        System.out.println("Welcome to tic tac toe");

        int row;
        int col;
        clearBoard();

        do {
            do {
                displayBoard();
                if (playerTurn % 2 == 0) {
                    player = playerOne;
                }
                else {
                    player = playerTwo;
                }

                do {

                    row = InputHelper.getRangedInt(scan, "Enter your move row [1-3]", 1, 3) - 1;
                    col = InputHelper.getRangedInt(scan, "Enter your move column [1-3]", 1, 3) - 1;
                } while(!isValidMove(row, col));
                gameBoard[row][col] = player;
                if(isWin(player)) {
                    displayBoard();
                    System.out.println("Player " + player + " won!");
                    break;
                }

                playerTurn++;

            } while(!isTie());
            if (isTie()) {
                displayBoard();
                System.out.println("You tied");
            }
            clearBoard();
            repeat = InputHelper.getYNConfirm(scan, "Do you want to play again?");
            playerTurn = 0;

        } while (repeat);


    }

     private static boolean isValidMove(int row, int col) {
        if (gameBoard[row][col].equalsIgnoreCase("-")) {
            return true;
        }
        else {
            return false;
        }
    }


     private static void clearBoard() {
        for(int r = 0; r < gameBoard.length; r++) {
            for(int c = 0; c < gameBoard[0].length; c++) {
                gameBoard[r][c] = "-";
            }
        }
    }

 private static void displayBoard() {
     for(int r = 0; r < gameBoard.length; r++) {
         for(int c = 0; c < gameBoard[0].length; c++) {
             System.out.print(gameBoard[r][c] + " ");
         }
         System.out.println();
     }
 }

 private static boolean isWin(String player) {
    if (isColWin(player) || isRowWin(player) || isDiagonalWin(player)) {
        return true;
    }
    else {
        return false;
    }
 }

 private static boolean isColWin(String player) {
    boolean win = true;
        for(int c = 0; c < gameBoard[0].length; c++) {
            win = true;
                for(int r = 0; r < gameBoard.length; c++) {
                    if(!player.equals(gameBoard[r][c])) {
                        win = false;
                        break;
                    }
                }
               if (win) {
                   break;
               }
        }
        return win;
 }

 private static boolean isRowWin(String player) {
     boolean win = true;
     for(int r = 0; r < gameBoard[0].length; r++) {
         win = true;
         for(int c = 0; c < gameBoard.length; c++) {
             if(!player.equals(gameBoard[r][c])) {
                 win = false;
                 break;
             }
         }
         if (win) {
             break;
         }
     }
     return win;
 }

 private static boolean isDiagonalWin(String player) {
     boolean win = false;
     boolean diagonalDown = false;
     boolean diagonalUp = false;

     for (int r = 0; r < gameBoard[0].length; r++) {
        if(player.equals(gameBoard[r][r])) {
            diagonalDown = true;
        }
        else if (player.equals(gameBoard[r][gameBoard.length-(r+1)])) {
            diagonalUp = true;
         }
     }

     if (diagonalUp || diagonalDown) {
         win = true;
     }

     return win;
 }

 private static boolean isTie() {
     boolean isFilled = true;
     boolean tie = false;
     for (int r = 0; r < gameBoard[0].length; r++) {
         for (int c = 0; c < gameBoard.length; c++) {
            if (gameBoard[r][c].equals("-")) {
                isFilled = false;
                break;
            }

         }
     }
     if(isFilled && !isWin("X") || isFilled && !isWin("O")) {
         tie = true;
     }
     return tie;
 }



 }
