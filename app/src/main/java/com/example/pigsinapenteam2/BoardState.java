package com.example.pigsinapenteam2;

/**
 * stores the state of the board and all inputted data.
 * The board is a 3D array with a format as follows:
 * [x coordinate][y coordinate][wall data and cell data]
 * for wall data and cell data, 0-3 are for the four walls of the cell, and
 * 4 is for the cell data itself
 */
public class BoardState {

  private int[][][] boardData;
  private int width;
  private int height;

  /**
   * default constructor for BoardState. Sets the board as a 10x10 empty board
   *
   */
  public BoardState() {

    boardData = new int[10][10][5];
    width = 10;
    height = 10;
  }//default constructor

  /**
   * contructor for BoardState. creates a board of inputted size and assigns class
   * variables.
   * @param inputtedWidth
   * @param inputtedHeight
   */
  public BoardState(int inputtedWidth, int inputtedHeight){

    boardData = new int[inputtedWidth][inputtedHeight][5];
    width = inputtedWidth;
    height = inputtedHeight;
  }//constructor

  public int getWidth(){

    return width;

  }//getWidth

  public int getHeight(){

    return height;

  }//getHeight

  public int getCellState(int xCoord, int yCoord){

    return boardData[xCoord][yCoord][4];

  }//getCellState

  public void setCellState(int xCoord, int yCoord, int cellInput){

    boardData[xCoord][yCoord][4] = cellInput;

  }//setCellState

  public int getTopWallState(int xCoord, int yCoord){

    return boardData[xCoord][yCoord][0];
  }//getTopWallState

  public void setTopWallState(int xCoord, int yCoord, int wallInput){

    boardData[xCoord][yCoord][0] = wallInput;

    if(yCoord > 0){
      boardData[xCoord][yCoord - 1][2] = wallInput;
    }//if statement

  }//setTopWallState


}
