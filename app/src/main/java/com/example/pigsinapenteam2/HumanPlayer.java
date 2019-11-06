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

    private boolean hasMoved;

    public Player(boolean hasMoved){
        this.hasMoved = false;
    }

    /**
     * hasMoved
     *
     * A getter for the hasMoved variable.
     *
     * @return boolean hasMoved, true if player has moved, false if player has not
     */
    public boolean hasMoved(){
        return hasMoved;
    }

    public int setNextMove(){

    }
}
