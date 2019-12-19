/**
 * Jared Boonstra - 1572694
 *
 * HumanPlayer.java
 * public methods:
 * doMove: GameState
 *  changes the GameState according to the moves the player does
 */
package com.example.pigsinapenteam2;


public class HumanPlayer extends Player {


    public HumanPlayer(){
    }

    /**
     * doMove
     *
     * takes the location of the cell that is going to be changed and sets the boardState to the new move
     *
     * EDIT BY BENJAMIN: Added a int input for which player it is. needed for score check
     *
     * @param inputState an inputted gameState board of pigs + pen
     * @return an output gameState with the updated value for a wall.
     */

   public GameState doMove(GameState inputState, int cellX, int cellY,
                           int playerMark, boolean isHorizontal){

       inputState.currentBoardState.setWall(cellX, cellY, isHorizontal);
       inputState.currentBoardCheck.boardChecker(playerMark);


        return inputState;
   }

}
