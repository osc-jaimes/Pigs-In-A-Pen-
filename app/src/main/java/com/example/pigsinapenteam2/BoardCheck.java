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

    int checkedCellX;
    int checkedCellY;

    if(playerInt == 1) {

       checkedCellX = cellXCheck(cellX);
       checkedCellY = cellYCheck(cellY);
    }//if statement
    else{
      checkedCellX = cellX;
      checkedCellY = cellY;
    }//else statement


    if(this.currentBoard.isComplete(checkedCellX, checkedCellY)){

      this.currentBoard.setCellState(checkedCellX, checkedCellY, playerInt);

    }//if statement

    else if(checkedCellX > 0){

      if(this.currentBoard.isComplete(checkedCellX -1, checkedCellY)){

        this.currentBoard.setCellState(checkedCellX -1,checkedCellY, playerInt);

      }//if
    }//else if

    else if(checkedCellY  > 0){

      if(this.currentBoard.isComplete(checkedCellX, checkedCellY - 1)){

        this.currentBoard.setCellState(checkedCellX, checkedCellY -1, playerInt);

      }//if
    }//else if
    else{
      System.out.println("isComplete was false");
    }
  }//cellCheckAndUpdate

  private int cellXCheck(int cellX){

    if(cellX >= currentBoard.getWidth()){

      System.out.println("cellX was greater or equal to Height");
      System.out.println(cellX);
      return cellX - 1;

    }//if statement

    else{

      return cellX;

    }//else statement
  }//cellXCheck

  private int cellYCheck(int cellY){

    if(cellY >= currentBoard.getHeight()){

      System.out.println("cellY was greater or equal to Width");
      System.out.println(cellY);
      return cellY - 1;

    }//if statement

    else{

      return cellY;

    }//else statement
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
        cellY = 3;

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
        cellY = 3;

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
        cellX = 0;
        cellY = 3;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h4":
        cellX = 1;
        cellY = 0;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h5":
        cellX = 1;
        cellY = 1;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h6":
        cellX = 1;
        cellY = 2;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;

      case "h7":
        cellX = 1;
        cellY = 3;

        cellCheckAndUpdate(cellX, cellY, BOTPLAYERINT);
        break;
    }
  }//botButtonChecker

  public int getPlayerOneScore(){

    return playerOneScore;

  }//getPlayerOneScore

  public int getPlayerTwoScore(){

    return playerTwoScore;

  }//getPlayerTwoScore

}//BoardCheck
