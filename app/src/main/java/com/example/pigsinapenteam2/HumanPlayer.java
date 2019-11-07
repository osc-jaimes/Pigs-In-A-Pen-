/**
 * Jared Boonstra - 1572694
 *
 * HumanPlayer.java
 *
 * public methods:
 * hasMoved: returns true or false if the player has moved or not.
 */
package com.example.pigsinapenteam2;

public class HumanPlayer extends Player {
// Variables
    private boolean hasMoved;
    private int nextMoveX;
    private int nextMoveY;
    private boolean nextMoveIsHorizontal;
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
     * setNextMove
     *
     * sets variables to store for other functions to use in a turn.
     *
     * @param xCoordinate the x coordinate the player chooses
     * @param yCoordinate the y coordinate the player chooses
     * @param isHorizontal a boolean true if the move is horizontal and false if vertical
     */
    public void setNextMove(int xCoordinate, int yCoordinate, boolean isHorizontal){
        nextMoveX = xCoordinate;
        nextMoveY = yCoordinate;
        nextMoveIsHorizontal = isHorizontal;
    }

    /**
     * nextMoveIsHorizontal
     *
     * getter for the boolean nextMoveIsHorizontal variable.
     *
     * @return boolean nextMoveIsHorizontal, true if move horizontal, false if vertical
     */
    public boolean nextMoveIsHorizontal(){
        return nextMoveIsHorizontal;
    }

    @Override
    public GameState doMove(GameState){

    }

}
