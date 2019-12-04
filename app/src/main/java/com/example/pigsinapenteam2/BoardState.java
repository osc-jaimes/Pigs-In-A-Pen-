package com.example.pigsinapenteam2;

import androidx.annotation.NonNull;

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
  private int topWallState;
  private int rightWallState;
  private int bottomWallState;
  private int leftWallState;
  private int cellState;

  //=======================================================================================
  /**
   * contructor for BoardState. creates a board of inputted size and assigns class
   * variables.
   * @param inputtedWidth
   * @param inputtedHeight
   */
  public BoardState(int inputtedWidth, int inputtedHeight){

    boardData = new int[inputtedHeight][inputtedWidth][5];
    width = inputtedWidth;
    height = inputtedHeight;
    topWallState = 0;
    rightWallState = 1;
    bottomWallState = 2;
    leftWallState = 3;
    cellState = 4;
  }//constructor

  //=======================================================================================
  public int getWidth(){

    return width;

  }//getWidth

  //=======================================================================================
  public int getHeight(){

    return height;

  }//getHeight

  //=======================================================================================
  /**
   * gets data from the saved cell data at the specified coordinates
   * @param row
   * @param cols
   * @return    the int value at [row][cols][4]
   */
  public int getCellState(int row, int cols){

    return boardData[row][cols][cellState];

  }//getCellState

  //=======================================================================================
  /**
   * sets data for the cell state at the specified coordinates
   * @param row
   * @param cols
   * @param cellInput the new int value at [row][cols][4]
   */
  public void setCellState(int row, int cols, int cellInput){

    boardData[row][cols][cellState] = cellInput;

  }//setCellState

  //=======================================================================================
  /**
   * gets the top wall at specified coordinates             *----------*   <== retrieves this
   * @param row                                             |          |
   * @param cols                                            |          |
   * @return the data of the top wall                       *----------*
   */
  private int getTopWallState(int row, int cols){

    return boardData[row][cols][topWallState];

  }//getTopWallState

  //=======================================================================================
  /**
   * sets the top wall at specified coordinates            *----------*   <== sets this
   * @param row                                            |          |
   * @param cols                                           |          |
   * @param                                                *----------*
   */
  private void setTopWallState(int row, int cols){

    if(row >= height){

      setBottomWallState(row - 1, cols);
      return;
    }//if statement

    boardData[row][cols][topWallState] = 1;

    if(row > 0){

      boardData[row - 1][cols][bottomWallState] = 1;

    }

  }//setTopWallState

  //=======================================================================================
  /**
   * gets the right wall at specified coordinates          *----------*
   * @param row                                            |          | <== retrieves this
   * @param cols                                           |          |
   * @return the data of the right wall                    *----------*
   */
  private int getRightWallState(int row, int cols){

    return boardData[row][cols][rightWallState];

  }//getRightWallState


  //=======================================================================================
  /**
   * sets the right wall at specified coordinates         *----------*
   * @param row                                           |          |  <== sets this
   * @param cols                                          |          |
   *                                                      *----------*
   */
  private void setRightWallState(int row, int cols){

    boardData[row][cols][rightWallState] = 1;

    if(cols < (width - 1)){

      boardData[row][cols + 1][leftWallState] = 1;

    }//if statement
  }//setRightWallState

  //=======================================================================================
  private int getBottomWallState(int row, int cols){

    return boardData[row][cols][bottomWallState];

  }//getBottomWallState

  //=======================================================================================
  private void setBottomWallState(int row, int cols){

    boardData[row][cols][bottomWallState] = 1;

    if(row < (height - 1)){

      boardData[row + 1][cols][topWallState] = 1;

    }//if statement
  }//setBottomWallState

  //=======================================================================================
  private int getLeftWallState(int row, int cols){

    return boardData[row][cols][leftWallState];

  }//getLeftWallState

  //=======================================================================================
  private void setLeftWallState(int row, int cols){

    if(cols >= width){

      setRightWallState(row, cols -1);
      return;
    }//if statement
    System.out.println("Before left wall");
    boardData[row][cols][leftWallState] = 1;
    System.out.println("After left wall");

    if(cols > 0){
      System.out.println("Before right wall");
      boardData[row][cols - 1][rightWallState] = 1;
      System.out.println("After right wall");
    }//if statement
  }//setLeftWallState

  //=======================================================================================
  public boolean isComplete( int row, int cols) {


    for(int i = 0; i < 4; i++){

      if((boardData[row][cols][i] == 0) || boardData[row][cols][i] == 3){

        return false;

      }//if statement
    }//for loop


    return true;

  }//isComplete

  /**
   * sets walls based on if horizontal or vertical. places at x, y coordinate
   * @param row  x coordinate on 2D array
   * @param cols Y coordinate on 2D array
   * @param isHorizontal  boolean to know if wall needing to be placed is horizontal
   */
  public void setWall(int row, int cols, boolean isHorizontal){
    if(!(isHorizontal)){
      setLeftWallState(row, cols);

    }//if
    else{
      setTopWallState(row, cols);
    }//else
  }//setTopWall

  public void setWallAi(int cols, int row, int wallDirection){

    switch(wallDirection){

      case 0 :

        setTopWallState(row, cols);
        break;

      case 1:

        setRightWallState(row, cols);
        break;

      case 2:

        setBottomWallState(row, cols);
        break;

      case 3:

        setLeftWallState(row, cols);
        break;

      default:

        break;

    }//switch

  }//setWallAi

  /**
   * getWall is used for BotPlayer to see a inputted wall.
   * @param row
   * @param cols
   * @param wantedWall 0 for top, 1 for right, 2 bottom, 3 left
   */
  public int getWallAi(int cols, int row, int wantedWall){

    switch(wantedWall){

      case 0:

        return getTopWallState(row, cols);

      case 1:

        return getRightWallState(row, cols);

      case 2:

        return getBottomWallState(row, cols);

      case 3:

        return getLeftWallState(row, cols);

      default:
        return -1;
    }//switch
  }//getWallAi



  @Override
  public String toString(){
    String finalStr = "";
    for(int i = 0; i < this.boardData.length; i++){
      for(int j = 0; j < this.boardData[i].length; j++){
        for(int k = 0; k < this.boardData[i][j].length; k++ ){
          finalStr += "" + this.boardData[i][j][k];

        }
        finalStr += " ";
      }
      finalStr += "\n";
    }

    finalStr += " End";

    return finalStr;
  }

}//BoardState
