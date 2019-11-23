/**
 * Jared Boonstra - 1572694
 *
 * HumanPlayer.java
 *
 * public methods:
 * hasMoved: returns true or false if the player has moved or not.
 * doMove: changes the GameState according to the moves the player does
 */
package com.example.pigsinapenteam2;


public class HumanPlayer extends Player {
// Variables
    private boolean hasMoved;
    //


    public HumanPlayer(){
        this.hasMoved = false;
    }

    /**
     * getHasMoved
     *
     * A getter for the hasMoved variable.
     *
     * @return boolean hasMoved, true if player has moved, false if player has not
     */
    public boolean getHasMoved(){
        return hasMoved;
    }



    /**
     * doMove
     *
     * takes the location of the cell that is going to be changed and sets the boardState to the new move
     *
     *
     * @param inputState an inputted gameState board of pigs + pen
     * @return an output gameState with the updated value for a wall.
     */
   @Override
   public GameState doMove(GameState inputState, int cellX, int cellY, boolean isHorizontal){
       inputState.getBoardState().setWall(cellX, cellY, isHorizontal);
        return inputState;
   }

}
