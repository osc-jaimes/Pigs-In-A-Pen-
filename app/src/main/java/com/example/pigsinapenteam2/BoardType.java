package com.example.pigsinapenteam2;

public class BoardType {


  private int width;
  private int height;

  //=======================================================================================

  public BoardType(BoardState inputtedState, int boardID, String boardSize){

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
}
