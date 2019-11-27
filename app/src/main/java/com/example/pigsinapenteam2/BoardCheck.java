package com.example.pigsinapenteam2;


public class BoardCheck {

  int playerOneScore;
  int playerTwoScore;
  BoardState currentBoard;

  public BoardCheck( BoardState instanceBoard){

    playerOneScore = 0;
    playerTwoScore = 0;
    currentBoard = instanceBoard;

  }//BoardCheckConstructor

  public void boardChecker(){

    for(int i = 0; i <= currentBoard.getWidth(); i++){
      for(int j = 0; j <= currentBoard.getHeight(); j++){

        cellScoreCheck(i,j);

      }//inner for loop
    }//for loop
  }//boardChecker

  private void cellScoreCheck(int xCoord, int yCoord)



}
