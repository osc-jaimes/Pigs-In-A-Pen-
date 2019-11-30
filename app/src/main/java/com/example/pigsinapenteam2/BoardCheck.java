package com.example.pigsinapenteam2;


public class BoardCheck {

  private int playerOneScore;
  private int playerTwoScore;
  private BoardState currentBoard;

  public BoardCheck( BoardState instanceBoard){

    this.playerOneScore = 0;
    this.playerTwoScore = 0;
    this.currentBoard = instanceBoard;

    boardChecker();

  }//BoardCheckConstructor

  public void boardChecker(){

    for(int i = 0; i < currentBoard.getWidth(); i++){
      for(int j = 0; j < currentBoard.getHeight(); j++){

        cellScoreCheck(i,j);

      }//inner for loop
    }//for loop
  }//boardChecker

  private void cellScoreCheck(int xCoord, int yCoord){
    int input = currentBoard.getCellState(xCoord, yCoord);

    switch (input){

      case 1:
        playerOneScore += 1;
        break;

      case 2:
        playerTwoScore += 1;
        break;

      default:
        break;
    }//switch

  }//cellScoreCheck

  public int getPlayerOneScore(){

    return playerOneScore;

  }//getPlayerOneScore

  public int getPlayerTwoScore(){

    return playerTwoScore;

  }//getPlayerTwoScore

}//BoardCheck
