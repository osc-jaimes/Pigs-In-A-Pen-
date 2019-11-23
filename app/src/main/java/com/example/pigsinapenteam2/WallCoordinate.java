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

  /**
   * WallCoordinates: Constructor
   * @param xCoord
   * @param yCoord
   * @param wallPos: 0 for top, 1 for right, onwards clockwise (max 3)
   */
  public void WallCoordinate(int xCoord, int yCoord, int wallPos) {
    x = xCoord;
    y = yCoord;
    wallPosition = wallPos;
  }

  /**
   * default constructor
   */
  public void WallCoordinate() {
    x = 0;
    y = 0;
    wallPosition = 0;
  }

  /**
   * incomplete constructor: sets wallPosition to top (0)
   * @param xCoord
   * @param yCoord
   */
  public void wallCoordinate(int xCoord, int yCoord) {
    x = xCoord;
    y = yCoord;
    wallPosition = 0;
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
}
