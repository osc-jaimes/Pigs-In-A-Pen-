package com.example.pigsinapenteam2;

/**
 * stores the state of the board and all inputted data.
 * The board is a 3D array with a format as follows:
 * [x coordinate][y coordinate][wall data and cell data]
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
}
