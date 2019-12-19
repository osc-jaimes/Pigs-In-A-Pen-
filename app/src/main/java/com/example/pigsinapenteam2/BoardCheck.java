package com.example.pigsinapenteam2;


public class BoardCheck {

  private int playerOneScore;
  private int playerTwoScore;
  private final int BOTPLAYERINT;
  private BoardState currentBoard;

  public BoardCheck( BoardState instanceBoard){

    this.playerOneScore = 0;
    this.playerTwoScore = 0;
    this.currentBoard = instanceBoard;
    this.BOTPLAYERINT = 2;


  }//BoardCheckConstructor

  public void boardChecker(int playerMarker){

    for(int i = 0; i < currentBoard.getHeight(); i++){
      for(int j = 0; j < currentBoard.getWidth(); j++){

        if(currentBoard.isComplete(i,j)){
          currentBoard.setCellState(i, j, playerMarker);

        }//if statement

      }//inner for loop
    }//for loop
  }//boardChecker

  private void cellScoreCheck(int row, int cols){

    int input = this.currentBoard.getCellState(row, cols);
    int checkedCell = 3;

    switch (input){

      case 1:
        playerOneScore += 1;
        this.currentBoard.setCellState(row, cols, checkedCell);
        break;

      case 2:
        playerTwoScore += 1;
        this.currentBoard.setCellState(row, cols, checkedCell);
        break;

      default:
        break;
    }//switch

  }//cellScoreCheck

  public void scoreCheck() {
    for(int i = 0; i < currentBoard.getHeight(); i++){
      for(int j = 0; j < currentBoard.getWidth(); j++){

        cellScoreCheck(i,j);

      }//inner for loop
    }//for loop
  }




  public int getPlayerOneScore(){

    return playerOneScore;

  }//getPlayerOneScore

  public int getPlayerTwoScore(){

    return playerTwoScore;

  }//getPlayerTwoScore

}//BoardCheck
