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

  public int getWallPosition() {
    return wallPosition;
  }

  public void setWallPosition(int newWallPosition) {
    wallPosition = newWallPosition;
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

  public String getButtonName() {
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

    buttonName += cellNum;

    return buttonName;
  }
}
