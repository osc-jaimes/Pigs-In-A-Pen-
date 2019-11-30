package com.example.pigsinapenteam2;

public class GameState {
  //Variables
  private BoardState currentBoardState;
  private BoardCheck currentBoardCheck;
  private int currentPlayer;
  private Player player1;
  private Player player2;
  private int player1Points;
  private int player2Points;
  private int gameMode;
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
    this.currentBoardState = currentBoardState;
    this.currentBoardCheck = new BoardCheck(currentBoardState);
    this.player1Points = currentBoardCheck.getPlayerOneScore();
    this.player2Points = currentBoardCheck.getPlayerTwoScore();
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
   return this.player1.isBot();
  }

  /**
   * isBotP2
   *
   * return true or false if player two is a bot or human; true for bot, false for human
   *
   * @return boolean isBot
   */

  public boolean isBotPlayer2(){

    return this.player2.isBot();

  }


  public int getPlayer1Points(){

    return player1Points;

  }

  public int getPlayer2Points(){

    return player2Points;

  }

  public BoardState getBoardState(){

    return this.currentBoardState;

  }
}
