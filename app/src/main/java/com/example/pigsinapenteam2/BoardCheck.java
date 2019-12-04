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

    boardChecker();

  }//BoardCheckConstructor

  public void boardChecker(){

    for(int i = 0; i < currentBoard.getHeight(); i++){
      for(int j = 0; j < currentBoard.getWidth(); j++){

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

  public void cellCheckAndUpdate(int cellX,int cellY, int playerInt){


  }//cellCheckAndUpdate

  private int cellXCheck(int cellX){

  }//cellXCheck

  private int cellYCheck(int cellY){

  }//cellYCheck

  public void botButtonChecker(String buttonName){


    int cellX;
    int cellY;

    switch (buttonName){

      case "v0":
        cellX = 0;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "v1":
        cellX = 0;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "v2":
        cellX = 0;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "v3":
        cellX = 0;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "v4":
        cellX = 1;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "v5":
        cellX = 1;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "v6":
        cellX = 1;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "v7":
        cellX = 1;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h0":
        cellX = 0;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h1":
        cellX = 0;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h2":
        cellX = 0;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h3":
        cellX = 1;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h4":
        cellX = 1;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h5":
        cellX = 1;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h6":
        cellX = 1;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h7":
        cellX = 1;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h8":
        cellX = 1;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
    }
  }//botButtonChecker

  public int getPlayerOneScore(){

    return playerOneScore;

  }//getPlayerOneScore

  public int getPlayerTwoScore(){

    return playerTwoScore;

  }//getPlayerTwoScore

}//BoardCheck
