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

  //=======================================================================================
  /**
   * default constructor for BoardState. Sets the board as a 10x10 empty board
   *
   */
  public BoardState() {

    boardData = new int[10][10][5];
    width = 10;
    height = 10;
  }//default constructor

  //=======================================================================================
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

    return boardData[xCoord][yCoord][4];

  }//getCellState

  //=======================================================================================
  /**
   * sets data for the cell state at the specified coordinates
   * @param xCoord
   * @param yCoord
   * @param cellInput the new int value at [xCoord][yCoord][4]
   */
  public void setCellState(int xCoord, int yCoord, int cellInput){

    if(xCoord > width){
      return;

    }//if statement

    if(yCoord > height){
      return;
    }//if statement

    boardData[xCoord][yCoord][4] = cellInput;

  }//setCellState

  //=======================================================================================
  /**
   * gets the top wall at specified coordinates             *----------*   <== retrieves this
   * @param xCoord                                          |          |
   * @param yCoord                                          |          |
   * @return the data of the top wall                       *----------*
   */
  private int getTopWallState(int xCoord, int yCoord){

    if(xCoord > width){
      return 0;
    }//if statement

    if(yCoord > height){
      return getBottomWallState(xCoord, yCoord-1);
    }//if statement

    return boardData[xCoord][yCoord][0];

  }//getTopWallState

  //=======================================================================================
  /**
   * sets the top wall at specified coordinates             *----------*   <== sets this
   * @param xCoord                                          |          |
   * @param yCoord                                          |          |
   * @param input                                       *----------*
   */
  private void setTopWallState(int xCoord, int yCoord, int input){

    if(xCoord > width) {
      return;
    }//if statement

    //checks if yCoordinate is greater than board, then sets bottom wall state instead
    if(yCoord > height){
      setBottomWallState(xCoord, yCoord-1, input);
      return;
    }// if statement

    boardData[xCoord][yCoord][0] = input;

    if(yCoord > 0){
      boardData[xCoord][yCoord - 1][2] = input;

    }//if statement

  }//setTopWallState

  //=======================================================================================
  /**
   * gets the right wall at specified coordinates           *----------*
   * @param xCoord                                          |          | <== retrieves this
   * @param yCoord                                          |          |
   * @return the data of the right wall                     *----------*
   */
  private int getRightWallState(int xCoord, int yCoord){

    if(xCoord > width){
      return 0;
    }//if statement

    if(yCoord > height){
      return 0;
    }//if statement

    return boardData[xCoord][yCoord][1];

  }//getRightWallState


  //=======================================================================================
  /**
   * sets the right wall at specified coordinates           *----------*
   * @param xCoord                                          |          |  <== sets this
   * @param yCoord                                          |          |
   * @param input                                           *----------*
   */
  private void setRightWallState(int xCoord, int yCoord, int input){

    if(xCoord > width){
      return;
    }//if statement

    if(yCoord > height){
      return;
    }//if statement

    boardData[xCoord][yCoord][1] = input;

    if(xCoord < width){

      boardData[xCoord + 1][yCoord][3] = input;

    }//if statement
  }//setRightWallState

  //=======================================================================================
  private int getBottomWallState(int xCoord, int yCoord){

    if(xCoord > width){
      return 0;
    }//if statement

    if(yCoord > height){
      return 0;
    }// if statement

    return boardData[xCoord][yCoord][2];

  }//getBottomWallState

  //=======================================================================================
  private void setBottomWallState(int xCoord, int yCoord, int input){

    if(xCoord > width){
      return;
    }//if statement

    if(yCoord > height){
      return;
    }//if statement

    boardData[xCoord][yCoord][2] = input;

    if(yCoord > 0){

      boardData[xCoord][yCoord + 1][0] = input;

    }//if statement
  }//setBottomWallState

  //=======================================================================================
  private int getLeftWallState(int xCoord, int yCoord){

    if(xCoord > width){

      return getRightWallState(xCoord-1, yCoord);
    }//if statement

    if(yCoord > height){
      return 0;
    }//if statement

    return boardData[xCoord][yCoord][3];

  }//getLeftWallState

  //=======================================================================================
  private void setLeftWallState(int xCoord, int yCoord, int input){

    if(xCoord > width){
      setRightWallState(xCoord-1, yCoord, input);
      return;
    }//if statement

    if(yCoord > height){
      return;
    }//if statement

    boardData[xCoord][yCoord][3] = input;

    if(xCoord > 0){

      boardData[xCoord - 1][yCoord][1] = input;

    }//if statement

  }//setLeftWallState

  //=======================================================================================
  public boolean isComplete( int xCoord, int yCoord) {





    //adds all four wallStates together to check if cell is done
    for( int n = 0; n <= 3; n++){

      if(boardData[xCoord][yCoord][n] == 0){
        return false;
      }//if statement

    }//for loop

    return true;

  }//getWallState

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
  public void getWall(int xCoord, int yCoord, int wantedWall){

    switch(wantedWall){

      case 0:

        getTopWallState(xCoord, yCoord);
        break;

      case 1:

        getRightWallState(xCoord, yCoord);
        break;

      case 2:

        getBottomWallState(xCoord, yCoord);
        break;

      case 3:

        getLeftWallState(xCoord, yCoord);

      default:
        break;
    }//switch
  }

}//BoardState
