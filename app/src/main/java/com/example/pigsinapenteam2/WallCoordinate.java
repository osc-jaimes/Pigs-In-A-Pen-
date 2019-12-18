package com.example.pigsinapenteam2;

/**
 * WallCoordinate: for storing coordinates easily.
 *
 *  isHorizontal: true if position 0 or 2.
 *
 *  isVertical: true if position 1 or 3.
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

  public int getWallPosition() {
    return wallPosition;
  }

  public void setWallPosition(int newWallPosition) {
    wallPosition = newWallPosition;
    validPos = false;
    if ((-1 < wallPosition) && (wallPosition < 4)) {
      validPos = true;
    }
  }

  public boolean isValidPosition() {
    return validPos;
  }

  public boolean isValidCell() {
    validCell = false;
    if ((x < boardWidth) && (x > -1)) {
      if ((y < boardHeight) && (y > -1)) {
        validCell = true;
      }
    }

    return validCell;
  }

  public boolean isVertical() {
    return (wallPosition % 2 == 1);
  }

  public boolean isHorizontal() {
    return (wallPosition % 2 == 0);
  }

  public boolean isTop() {
    return (wallPosition == 0);
  }

  public boolean isRight() {
    return (wallPosition == 1);
  }

  public boolean isBottom() {
    return (wallPosition == 2);
  }

  public boolean isLeft() {
    return (wallPosition == 3);
  }

  public int[] getIndexForm() {
    int[] index = new int[3];
    index[0] = x;
    index[1] = y;
    index[2] = wallPosition;
    return index;
  }

  public boolean equals(WallCoordinate otherWall) {
    boolean isSame = true;

    isSame = isSame && (x == otherWall.x);
    isSame = isSame && (y == otherWall.y);
    isSame = isSame && (wallPosition == otherWall.getWallPosition());

    return isSame;
  }

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
