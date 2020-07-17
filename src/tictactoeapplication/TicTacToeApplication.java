 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeapplication;

import java.util.Scanner;

/**
 *
 * @author Lenovo ThinkPad L520
 */
public class TicTacToeApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner kb = new Scanner(System.in);

//        Allows for continous game
        boolean doYouWantToPlay = true;

        while (doYouWantToPlay) {
//            setting up Tokens and Ai
            System.out.println("****** Welcome to Tic Tac Toe! ******\nPick your character "
                    + "and which character I will be.");
            System.out.println();
            System.out.print("Enter your character : ");
            char plyrToken = kb.next().charAt(0);
            System.out.print("Enter opponent character : ");
            char oppToken = kb.next().charAt(0);
            TicTacToe game = new TicTacToe(plyrToken, oppToken);
            AI ai = new AI();

//            setting up how to play the game
            System.out.println();
            System.out.println("Enter number and token shall be put in its place."
                    + "\n(Numbers go 1-9 and left to right)");
            TicTacToe.printindexBoard();
            System.out.println();

//            Lets's play! keeps going until game over
            while (game.gameOver().equals("notOver")) {
                if (game.currentMarker == game.userMarker) {
//                USER TURN
                    System.out.println("It's your turn! Enter Spot for your token : ");
                    int spot = kb.nextInt();
//                 for invalid move 
                    while (!game.playTurn(spot)) {
                        System.out.println("Try Again. " + spot + " is invalid.");
                        spot = kb.nextInt();
                    }
                    System.out.println("You Picked " + spot + "!");
                } else {
//                    AI TURN
                    System.out.println("It's my Turn!");
//                    picks spot
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot + "!");
                }
//                prints current board
                System.out.println();
                game.printBoard();
                System.out.println();
            }
            System.out.println(game.gameOver());
            System.out.println();

//            sets ups new game depending on user respoonse
            System.out.println("To play again Enter(Y)");
            char x = kb.next().charAt(0);
            doYouWantToPlay = (x == 'Y' || x == 'y');
            System.out.println();
            System.out.println();

        }
    }

}
