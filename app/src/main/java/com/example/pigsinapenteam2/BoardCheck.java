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

    for(int i = 0; i < currentBoard.getWidth() - 1; i++){
      for(int j = 0; j < currentBoard.getHeight() - 1; j++){

        cellScoreCheck(i,j);

      }//inner for loop
    }//for loop
  }//boardChecker

  private void cellScoreCheck(int xCoord, int yCoord){

    int input = this.currentBoard.getCellState(xCoord, yCoord);
    int checkedCell = 3;

    switch (input){

      case 1:
        playerOneScore += 1;
        this.currentBoard.setCellState(xCoord, yCoord, checkedCell);
        break;

      case 2:
        playerTwoScore += 1;
        this.currentBoard.setCellState(xCoord, yCoord, checkedCell);
        break;

      default:
        break;
    }//switch

  }//cellScoreCheck

  public void singularCellCheck(int row, int cols){


  }//singularCellCheck

  public int getPlayerOneScore(){

    return playerOneScore;

  }//getPlayerOneScore

  public int getPlayerTwoScore(){

    return playerTwoScore;

  }//getPlayerTwoScore

}//BoardCheck
