package com.example.pigsinapenteam2;

public class GameState {
    //Variables
    BoardState currentBoardState;
    int currentPlayer;
    Player player1;
    Player player2;
    int player1Points;
    int player2Points;
    int gameMode;
    //

    /**
     * getGameMode
     *
     * Getter for gameMode
     *
     * @return int gameMode
     */
    public int getGameMode(){
        return gameMode;
    }

    /**
     * isBotP1
     *
     * Return true or false if player one is a bot or not: true for bot, false for human
     *
     * @return boolean isBot
     */
    public boolean isBotP1(){
        return Player1.isBot();
    }

    /**
     * isBotP2
     *
     * return true or false if player two is a bot or human; true for bot, false for human
     *
     * @return boolean isBot
     */

    public boolean isBotP2(){
        return Player2.isBot();
    }
}
