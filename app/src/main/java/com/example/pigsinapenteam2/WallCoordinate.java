package com.example.pigsinapenteam2;

/**
 *  WallCoordinate: for storing wall positions easily.
 *
 *  getWallPosition() -> int:
 *    returns the position of the wall: 0 up, 1 right, 2 down, 3 left.
 *  setWallPosition(int):
 *    sets the position of the wall: 0 up, 1 right, 2 down, 3 left.
 *  isValidPosition() -> boolean:
 *    returns true if wall position is in range [0,3].
 *  isValidCell() -> boolean:
 *    returns true if the x,y coordinates are within the limits of the board.
 *  isVertical() -> boolean:
 *    returns true if the wall is a vertical one.
 *  isHorizontal() -> boolean:
 *    returns true if the wall is a horizontal one.
 *  isTop() -> boolean:
 *    returns true if the wall is on the top side of its x,y cell.
 *  isRight() -> boolean:
 *    returns true if the wall is on the right side of its x,y cell.
 *  isBottom() -> boolean:
 *    returns true if the wall is on the bottom side of its x,y cell.
 *  isLeft() -> boolean:
 *    returns true if the wall is on the left side of its x,y cell.
 *  getIndexForm() -> int[]:
 *    returns an array of the 3 values x,y,wallPosition for indexing into the board array.
 *  equals(WallCoordinate) -> boolean:
 *    returns true if the input wall has the same values as this wall.
 *  isSameWall(WallCoordinate) -> boolean:
 *    returns true if the input wall refers to the same on-board wall as this one.
 *  getButtonName(int) -> String:
 *    returns the name of the button this wall corresponds to; input argument must be
 *    0 if the board is small, 1 if medium-sized, and 2 if large.
 *  getOtherSideCoordinate() -> WallCoordinate:
 *    returns the wall coordinate referring to the same button on the board, but from
 *    the x,y coordinates of the cell on the other side.
 *  getStateOfThisWall(BoardState) -> int:
 *    returns the digit stored at coordinates y,x,wallPosition in BoardState.
 *  toString() -> String:
 *    returns an easily-readable string representation of this object.
 */
public class WallCoordinate {
  public int x;
  public int y;
  private int wallPosition; //0 to 3
  private int boardHeight;
  private int boardWidth;
  private boolean validCell;
  private boolean validPos;

  /**
   * WallCoordinates: Constructor
   * @param xCoord
   * @param yCoord
   * @param wallPos: 0 for top, 1 for right, onwards clockwise (max 3)
   */
  public WallCoordinate(int xCoord, int yCoord, int wallPos, int height, int width) {
    x = xCoord;
    y = yCoord;
    wallPosition = wallPos;
    boardHeight = height;
    boardWidth = width;

    validPos = false;
    if ((-1 < wallPos) && (wallPos < 4)) {
      validPos = true;
    }

    validCell = false;
    if (xCoord < width) {
      if (yCoord < height) {
        validCell = true;
      }
    }
  }

  /**
   * default constructor
   */
  public WallCoordinate() {
    x = 0;
    y = 0;
    wallPosition = 0;
    boardHeight = 0;
    boardWidth = 0;
    validCell = false;

  }
  /**
   *  getWallPosition() -> int:
   *    returns the position of the wall: 0 up, 1 right, 2 down, 3 left.
   *
   * @return: position of this wall.
   **/
  public int getWallPosition() {
    return wallPosition;
  }

  /**
   * setWallPosition(int):
   *    sets the position of the wall: 0 up, 1 right, 2 down, 3 left.
   *
   * @param newWallPosition: new position of the wall.
   */
  public void setWallPosition(int newWallPosition) {
    wallPosition = newWallPosition;
    validPos = false;
    if ((-1 < wallPosition) && (wallPosition < 4)) {
      validPos = true;
    }
  }

  /**
   * isValidPosition() -> boolean:
   *    returns true if wall position is in range [0,3].
   *
   * @return: if the position number is valid.
   */
  public boolean isValidPosition() {
    return validPos;
  }

  /**
   *  isValidCell() -> boolean:
   *    returns true if the x,y coordinates are within the limits of the board.
   *
   * @return: if the cell is on the board.
   */
  public boolean isValidCell() {
    validCell = false;
    if ((x < boardWidth) && (x > -1)) {
      if ((y < boardHeight) && (y > -1)) {
        validCell = true;
      }
    }

    return validCell;
  }

  /**
   * isVertical() -> boolean:
   *    returns true if the wall is a vertical one.
   *
   * @return: whether the wall is vertical.
   */
  public boolean isVertical() {
    return (wallPosition % 2 == 1);
  }

  /**
   * isHorizontal() -> boolean:
   *    returns true if the wall is a horizontal one.
   *
   * @return: whether the wall is horizontal.
   */
  public boolean isHorizontal() {
    return (wallPosition % 2 == 0);
  }

  /**
   * isTop() -> boolean:
   *    returns true if the wall is on the top side of its x,y cell.
   *
   * @return: whether the wall is a top one.
   */
  public boolean isTop() {
    return (wallPosition == 0);
  }

  /**
   * isRight() -> boolean:
   *    returns true if the wall is on the right side of its x,y cell.
   *
   * @return: whether the wall is a right one.
   */
  public boolean isRight() {
    return (wallPosition == 1);
  }

  /**
   * isBottom() -> boolean:
   *    returns true if the wall is on the bottom side of its x,y cell.
   *
   * @return: whether the wall is a bottom one.
   */
  public boolean isBottom() {
    return (wallPosition == 2);
  }

  /**
   * isLeft() -> boolean:
   *    returns true if the wall is on the left side of its x,y cell.
   *
   * @return: whether the wall is a left one.
   */
  public boolean isLeft() {
    return (wallPosition == 3);
  }

  /**
   * getIndexForm() -> int[]:
   *    returns an array of the 3 values x,y,wallPosition for indexing into the board array.
   *
   * @return: the board indices of this wall.
   */
  public int[] getIndexForm() {
    int[] index = new int[3];
    index[0] = x;
    index[1] = y;
    index[2] = wallPosition;
    return index;
  }

  /**
   * equals(WallCoordinate) -> boolean:
   *    returns true if the input wall has the same values as this wall.
   *
   * @param otherWall: wall to compare to
   * @return: whether the walls have the same values.
   */
  public boolean equals(WallCoordinate otherWall) {
    boolean isSame = true;

    isSame = isSame && (x == otherWall.x);
    isSame = isSame && (y == otherWall.y);
    isSame = isSame && (wallPosition == otherWall.getWallPosition());

    return isSame;
  }

  /**
   * isSameWall(WallCoordinate) -> boolean:
   *    returns true if the input wall refers to the same on-board wall as this one.
   *
   * @param otherWall: wall to compare to
   * @return: whether the walls are, on the board, the same wall.
   */
  public boolean isSameWall(WallCoordinate otherWall) {
    if (equals(otherWall)) {
      return true;
    }

    boolean xCorrect = false;
    boolean yCorrect = false;
    int otherWallPos = otherWall.getWallPosition();

    if (wallPosition == 0 && otherWallPos == 2) {
      xCorrect = (x == otherWall.x);
      yCorrect = (y == otherWall.y + 1);
    } else if (wallPosition == 2 && otherWallPos == 0) {
      xCorrect = (x == otherWall.x);
      yCorrect = (otherWall.y == y + 1);
    } else if (wallPosition == 1 && otherWallPos == 3) {
      xCorrect = (otherWall.x == x + 1);
      yCorrect = (y == otherWall.y);
    } else if (wallPosition == 3 && otherWallPos == 0) {
      xCorrect = (x == otherWall.x + 1);
      yCorrect = (y == otherWall.y);
    }

    return (xCorrect && yCorrect);
  }

  /**
   * getButtonName(int) -> String:
   *    returns the name of the button this wall corresponds to; input argument must be
   *    0 if the board is small, 1 if medium-sized, and 2 if large.
   *
   * @param mapSize: size of the map: 0,1, or 2 for small, medium, or large.
   * @return: name of the button on the screen.
   */
  public String getButtonName(int mapSize) {
    String buttonName = "";
    if (isHorizontal()) {
      buttonName += "h";
    } else {
      buttonName += "v";
    }

    int cellNum;
    if (isHorizontal()){
      cellNum = y * boardWidth + x;
      if (isBottom()) {
        cellNum += boardWidth;
      }
    } else { //isVertical()
      cellNum = y * (boardWidth + 1) + x;
      if (isRight()) {
        cellNum += 1;
      }
    }

    int smallMapCode = 0;
    int mediumMapCode = 1;
    int largeMapCode = 2;

    int smallMapWidth = 3;
    int smallMapHeight = 2;
    int mediumMapWidth = 4;
    int mediumMapHeight = 3;
    int smallMapHorizontalWalls = smallMapWidth * (smallMapHeight + 1);
    int smallMapVerticalWalls = (smallMapWidth + 1) * smallMapHeight;
    int mediumMapHorizontalWalls = mediumMapWidth * (mediumMapHeight + 1);
    int mediumMapVerticalWalls = (mediumMapWidth + 1) * mediumMapHeight;

    if (isHorizontal()) {
      if (mapSize == mediumMapCode) {
        cellNum += smallMapHorizontalWalls;
      }
      if (mapSize == largeMapCode) {
        cellNum += smallMapHorizontalWalls;
        cellNum += mediumMapHorizontalWalls;
      }
    } else {
      if (mapSize == mediumMapCode) {
        cellNum += smallMapVerticalWalls;
      }
      if (mapSize == largeMapCode) {
        cellNum += smallMapVerticalWalls;
        cellNum += mediumMapVerticalWalls;
      }
    }


    buttonName += cellNum;

    return buttonName;
  }

  /**
   * getOtherSideCoordinate() -> WallCoordinate:
   *    returns the wall coordinate referring to the same button on the board, but from
   *    the x,y coordinates of the cell on the other side.
   *
   * @return: coordinates of the same wall referenced from the other side.
   */
  public WallCoordinate getOtherSideCoordinate() {
    WallCoordinate otherSideWall;
    int newXCoord;
    int newYCoord;
    int newWallPos;
    if (isTop()) {
      newXCoord = x;
      newYCoord = y - 1;
      newWallPos = 2;
    } else if (isRight()) {
      newXCoord = x + 1;
      newYCoord = y;
      newWallPos = 3;
    } else if (isBottom()) {
      newXCoord = x;
      newYCoord = y + 1;
      newWallPos = 0;
    } else { //isLeft()
      newXCoord = x - 1;
      newYCoord = y;
      newWallPos = 1;
    }


    otherSideWall = new WallCoordinate(newXCoord, newYCoord, newWallPos,
          boardHeight, boardWidth);
    return otherSideWall;
  }

  /**
   * getStateOfThisWall(BoardState) -> int:
   *    returns the digit stored at coordinates y,x,wallPosition in BoardState.
   *
   * @param state: the state of the board.
   * @return: the digit stored at this location.
   */
  public int getStateOfThisWall(BoardState state) {
    if (isValidCell()) {
      return state.getWallAi(x,y,wallPosition);
    } else {
      WallCoordinate oppWall = getOtherSideCoordinate();
      if (oppWall.isValidCell()) {
        return state.getWallAi(oppWall.x,oppWall.y,oppWall.getWallPosition());
      } else {
        return 0;
      }
    }
  }

  /**
   * toString() -> String:
   *    returns an easily-readable string representation of this object.
   *
   * @return: string representation.
   */
  public String toString() {
    String outputString = "";
    outputString += "x coord: " + x + "\n";
    outputString += "y coord: " + y + "\n";
    outputString += "wall position: " + wallPosition + "\n";
    outputString += "board Height: " + boardHeight + "\n";
    outputString += "board Width: " + boardWidth + "\n";
    return outputString;
  }
}
