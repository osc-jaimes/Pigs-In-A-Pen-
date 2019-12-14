package com.example.pigsinapenteam2;

public class BoardType {

  private BoardState inputtedState;
  private int width;
  private int height;

  //=======================================================================================

  public BoardType(BoardState inputtedState, int boardID, int boardSize){

    this.inputtedState = inputtedState;
    this.width = inputtedState.getWidth();
    this.height = inputtedState.getHeight();


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

  }//gardenMapSetup

  private void hillMapSetup(int boardSize){

  }//hillMapSetup


}
