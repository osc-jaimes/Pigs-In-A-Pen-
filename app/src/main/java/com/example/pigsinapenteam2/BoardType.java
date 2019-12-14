package com.example.pigsinapenteam2;

public class BoardType {

  private BoardState inputtedState;
  private int width;
  private int height;

  //=======================================================================================

  public BoardType(BoardState inputtedState, int boardID, int boardSize){

    this.inputtedState = inputtedState;
    this.width = inputtedState.getWidth() - 1;
    this.height = inputtedState.getHeight() - 1;


    switch (boardID){

      case 1:

        wallsMapSetup(boardSize);
        break;

      case 2:

        gardenMapSetup(boardSize);
        break;

      case 3:

        hillMapSetup(boardSize);
        break;

      default:

        break;
    }//switch
  }//constructor

  private void wallsMapSetup(int boardSize){


  }//wallsMapSetup

  private void gardenMapSetup(int boardSize){

    int voidedCell = 3;

    //sets corners as void
    inputtedState.setCellState(0, width, voidedCell);
    inputtedState.setCellState(height, 0, voidedCell);

    //if boardsize is not Small
    if(boardSize > 0){

      inputtedState.setCellState(1, width, voidedCell);
      inputtedState.setCellState(height - 1, 0, voidedCell);

    }//if statement

    if(boardSize > 1){

      inputtedState.setCellState(0, width -1, voidedCell);
      inputtedState.setCellState(height, 1, voidedCell);

    }//if statement
  }//gardenMapSetup

  private void hillMapSetup(int boardSize){

  }//hillMapSetup


}
