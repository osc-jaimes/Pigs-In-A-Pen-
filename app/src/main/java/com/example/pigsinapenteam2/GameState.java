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
   * GameState
   *
   * Constructor of a GameState object - Takes info on player 1 and 2, including points and info from the player class.
   *
   *
   * @param player1 player1 class
   * @param player2 player2 class
   * @param player1Points points of player 1
   * @param player2Points points of player 2
   */
  public GameState(BoardState currentBoardState, Player player1, Player player2, int player1Points, int player2Points, int currentPlayer){
    this.player1 = player1;
    this.player2 = player2;
    this.player1Points = player1Points;
    this.player2Points = player2Points;
    this.currentBoardState = currentBoardState;
    this.currentPlayer = currentPlayer;
  }

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
  public boolean isBotPlayer1(){
    return Player1.isBot();
  }

  /**
   * isBotP2
   *
   * return true or false if player two is a bot or human; true for bot, false for human
   *
   * @return boolean isBot
   */

  public boolean isBotPlayer2(){
    return Player2.isBot();
  }


  public int getPlayer1Points(){
    return player1Points;
  }
  public int increasePlayer1Points(){
    return player1Points + 1;
  }
  public int getPlayer2Points(){
    return player2Points;
  }
  public int increasePlayer2Points(){
    return player2Points + 1;
  }
}
