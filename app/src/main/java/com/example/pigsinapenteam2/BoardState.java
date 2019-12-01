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
   * @param xCoord
   * @param yCoord
   * @return    the int value at [xCoord][yCoord][4]
   */
  public int getCellState(int xCoord, int yCoord){

    return boardData[xCoord][yCoord][cellState];

  }//getCellState

  //=======================================================================================
  /**
   * sets data for the cell state at the specified coordinates
   * @param xCoord
   * @param yCoord
   * @param cellInput the new int value at [xCoord][yCoord][4]
   */
  public void setCellState(int xCoord, int yCoord, int cellInput){

    boardData[xCoord][yCoord][cellState] = cellInput;

  }//setCellState

  //=======================================================================================
  /**
   * gets the top wall at specified coordinates             *----------*   <== retrieves this
   * @param row                                          |          |
   * @param cols                                          |          |
   * @return the data of the top wall                       *----------*
   */
  private int getTopWallState(int row, int cols){

    return boardData[row][cols][topWallState];

  }//getTopWallState

  //=======================================================================================
  /**
   * sets the top wall at specified coordinates             *----------*   <== sets this
   * @param xCoord                                          |          |
   * @param yCoord                                          |          |
   * @param input                                           *----------*
   */
  private void setTopWallState(int xCoord, int yCoord, int input){

  }//setTopWallState

  //=======================================================================================
  /**
   * gets the right wall at specified coordinates           *----------*
   * @param xCoord                                          |          | <== retrieves this
   * @param yCoord                                          |          |
   * @return the data of the right wall                     *----------*
   */
  private int getRightWallState(int xCoord, int yCoord){

    return boardData[xCoord][yCoord][rightWallState];

  }//getRightWallState


  //=======================================================================================
  /**
   * sets the right wall at specified coordinates           *----------*
   * @param xCoord                                          |          |  <== sets this
   * @param yCoord                                          |          |
   * @param input                                           *----------*
   */
  private void setRightWallState(int xCoord, int yCoord, int input){

  }//setRightWallState

  //=======================================================================================
  private int getBottomWallState(int xCoord, int yCoord){

    return boardData[xCoord][yCoord][bottomWallState];

  }//getBottomWallState

  //=======================================================================================
  private void setBottomWallState(int xCoord, int yCoord, int input){

  }//setBottomWallState

  //=======================================================================================
  private int getLeftWallState(int xCoord, int yCoord){

    return boardData[xCoord][yCoord][leftWallState];

  }//getLeftWallState

  //=======================================================================================
  private void setLeftWallState(int xCoord, int yCoord, int input){

  }//setLeftWallState

  //=======================================================================================
  public boolean isComplete( int xCoord, int yCoord) {


  }//isComplete

  /**
   * sets walls based on if horizontal or vertical. places at x, y coordinate
   * @param xCoord  x coordinate on 2D array
   * @param yCoord Y coordinate on 2D array
   * @param isHorizontal  boolean to know if wall needing to be placed is horizontal
   */
  public void setWall(int xCoord, int yCoord, boolean isHorizontal){
    if(!(isHorizontal)){
      setLeftWallState(xCoord, yCoord, 1);

    }//if
    else{
      setTopWallState(xCoord, yCoord, 1);
    }//else
  }//setTopWall

  public void setWallAi(int xCoord, int yCoord, int wallDirection){

     int wallInput = 1;

    switch(wallDirection){

      case 0 :

        setTopWallState(xCoord, yCoord, wallInput);
        break;

      case 1:

        setRightWallState(xCoord, yCoord, wallInput);
        break;

      case 2:

        setBottomWallState(xCoord, yCoord, wallInput);
        break;

      case 3:

        setLeftWallState(xCoord, yCoord, wallInput);
        break;

      default:

        break;

    }//switch

  }//setWallAi

  /**
   * getWall is used for BotPlayer to see a inputted wall.
   * @param xCoord
   * @param yCoord
   * @param wantedWall 0 for top, 1 for right, 2 bottom, 3 left
   */
  public int getWallAi(int xCoord, int yCoord, int wantedWall){

    switch(wantedWall){

      case 0:

        return getTopWallState(xCoord, yCoord);

      case 1:

        return getRightWallState(xCoord, yCoord);

      case 2:

        return getBottomWallState(xCoord, yCoord);

      case 3:

        return getLeftWallState(xCoord, yCoord);

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
