package com.example.pigsinapenteam2;

public class WallCoordinate {
  public int x;
  public int y;
  private int wallPosition; //0 to 3

  public void WallCoordinate(int xCoord, int yCoord, int wallPos) {
    x = xCoord;
    y = yCoord;
    wallPosition = wallPos;
  }
}
