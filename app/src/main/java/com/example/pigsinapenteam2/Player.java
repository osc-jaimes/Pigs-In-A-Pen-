/**
 * Jared Boonstra - 1572694
 *
 * Player.java
 *
 * The superclass of HumanPlayer and BotPlayer. It really is just a placeholder for those two
 * public methods:
 * doMove: GameState
 *  returns the current GameState
 *
 * isBot: boolean
 *  returns false, placeholder for isBot of subclasses
 */
package com.example.pigsinapenteam2;

public class Player {

    /**
     * doMove
     *
     * The default doMove. Doesn't adjust gameState.
     *
     * @param inputState an inputted gameState board
     * @return the gameState without any changes here.
     */
    public GameState doMove(GameState inputState){

      return inputState;

    }

    public boolean isBot(){

      return false;

    }


}
