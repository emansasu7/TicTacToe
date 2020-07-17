/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeapplication;

/**
 *
 * @author Lenovo ThinkPad L520
 */
public class TicTacToe {
//    This class implements the logic of our game.

//    properties
    protected char[] board; //board of chars where we'll be clicking buttons
//    marker for where marker is placed by players(pc's will be random)and 
//    whose turn is it.
    protected char userMarker, aiMarker, currentMarker;
    protected char winner;

    public TicTacToe(char playerToken, char aiToken) {
        this.userMarker = playerToken;
        this.aiMarker = aiToken;
        this.winner = '-';//because we started a new game no winner yet. 
        this.board = setBoard();
        this.currentMarker =userMarker;
    }

//    set up our TicTacToe board, anyone can use it but will be blank
    public static char[] setBoard() {
        char[] board = new char[9];
        for (int x = 0; x < board.length; x++) {
            board[x] = '-';
        }
        return board;
    }

//    to check availability and range of our spot and plays if valid
    public boolean playTurn(int x) {
        boolean isValid = withinRange(x) && !isSpotTaken(x);
        if (isValid) {
//            x-1 becuase user of "user Thinks" diagram
            board[x - 1] = currentMarker;
//            if statement that checks who played and flip currentMArker accordingly
            currentMarker = (currentMarker == userMarker) ? aiMarker : userMarker;
        }
        return isValid;
    }

//    check if spot is within range(1-9)
    public boolean withinRange(int x) {
        return x > 0 && x < board.length + 1;
    }

//    check is spot is taken
    public boolean isSpotTaken(int x) {
        return board[x - 1] != '-';
    }

//    prints out board
    public void printBoard() {
        System.out.println();
        for (int x = 0; x < board.length; x++) {
            if (x % 3 == 0 && x != 0) {
                System.out.println();
                System.out.println("---------------");
            }
            System.out.print(" | " + board[x]);
        }
        System.out.println();
    }

//    prints index of play
    public static void printindexBoard() {
        System.out.println();
        for (int x = 0; x < 9; x++) {
            if (x % 3 == 0 && x != 0) {
                System.out.println();
                System.out.println("---------------");
            }
            System.out.print(" | " + (x + 1));
        }
        System.out.println();
    }

//    checks if there's a winner and returns true.'
    public boolean isThereAWinner() {
        boolean diagonalsAndMids = (rDiag() || lDiag() || mRow() || sCol())
                && board[4] != '-';
        boolean topAndFirst = (tRow() || fCol()) && board[0] != '-';
        boolean btmAndThird = (bRow() || tCol()) && board[8] != '-';
//        checks usings the common spot for a winner
        if (diagonalsAndMids) {
            this.winner = board[4];
        } else if (topAndFirst) {
            this.winner = board[0];
        } else if (btmAndThird) {
            this.winner = board[8];
        }

        return diagonalsAndMids || topAndFirst || btmAndThird;
    }
//    helper functions for checking combos
//    rows

    public boolean tRow() {
        return board[0] == board[1] && board[1] == board[2];
    }

    public boolean mRow() {
        return board[3] == board[4] && board[4] == board[5];
    }

    public boolean bRow() {
        return board[6] == board[7] && board[7] == board[8];
    }
//    columns

    public boolean fCol() {
        return board[0] == board[3] && board[3] == board[6];
    }

    public boolean sCol() {
        return board[1] == board[4] && board[4] == board[7];
    }

    public boolean tCol() {
        return board[2] == board[5] && board[5] == board[8];
    }
//    diagonals

    public boolean rDiag() {
        return board[2] == board[4] && board[4] == board[6];
    }

    public boolean lDiag() {
        return board[0] == board[4] && board[4] == board[8];
    }

//    checks if the board is filled by looping through elements and returns t/f
    public boolean isBoardFilled() {
        for (int x = 0; x < board.length; x++) {
            if (board[x] == '-') {
                return false;
            }
        }
        return true;
    }

//    checks if the game is over based on the conditins we created
    public String gameOver() {
        boolean didSomeoneWin = isThereAWinner();
        if (didSomeoneWin) {
            return this.winner + " won.";
        } else if (isBoardFilled()) {
            return "DRAW: Game Over!";
        } else {
            return "notOver";
        }
    }

}
