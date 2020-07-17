/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeapplication;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Lenovo ThinkPad L520
 */
public class AI {
//    must know what game its playing and which spots are available to pick random spot

    public int pickSpot(TicTacToe game) {
        
        ArrayList<Integer> choices = new ArrayList();
        
//        loop to loop through all slots on board, 
        for (int x = 0; x < 9; x++) {
//        and if available add it as choice
            if (game.board[x] == '-') {
                choices.add(x + 1);//we're expecting something between(1-9)   
            }
        } 
//        randomly pick index betwwen 1-9 and return choice
        Random rand = new Random();
        int choice = choices.get(Math.abs(rand.nextInt() % choices.size()));
        return choice;

    }
}
